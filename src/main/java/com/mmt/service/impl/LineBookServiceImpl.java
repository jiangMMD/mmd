package com.mmt.service.impl;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.exceptions.ClientException;
import com.github.pagehelper.PageHelper;
import com.mmt.constant.SmsConstant;
import com.mmt.dao.LineBookDao;
import com.mmt.model.*;
import com.mmt.pjo.Page;
import com.mmt.pjo.Result;
import com.mmt.pjo.ResultPage;
import com.mmt.service.LineBookService;
import com.mmt.utils.PublicUtil;
import com.mmt.utils.SendSmsUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 线上订单
 */
@Service
public class LineBookServiceImpl implements LineBookService {

    @Autowired
    private LineBookDao lineBookDao;

    @Autowired
    private HttpSession session;
    /**
     * 通过订单审核
     * @param bid
     * @return
     */
    @Override
    public Result passBookAudit(String bid) throws Exception {
        //获取订单信息
        User user = (User) session.getAttribute("user");
        lineBookDao.passAudit(bid, user.getUser_no());
        //插入到消息中
        LineBook lineBook = lineBookDao.getBookInfo(bid);
        String title = "审核完成";
        String msg = "尊敬的"+lineBook.getName()+"，您的订单号："+lineBook.getBook_no()+"已经审核通过，请在我的订单中查看。";
        lineBookDao.insertNotify(title, msg, lineBook.getCustom_id(), user.getUser_no());

        //短信通知审核结果
        Map<String, String> smsParams = new HashMap<>();
        smsParams.put("name", lineBook.getName());
        smsParams.put("book_no", lineBook.getBook_no());
        Result result = SendSmsUtil.send(lineBook.getPhone(), SmsConstant.TEMPLATE_AUDIT, JSON.toJSONString(smsParams));
        if(result.getCode() == 0) {
            //说明短信发送失败
            return new Result(1, "审核操作已完成，通知短信发送失败："+result.getMessage()+"; 请联系管理员进行解决");
        }
        lineBookDao.insertBookOperLog(bid, 3, "审核通过", "订单已审核通过，审核人："+user.getUsername(), user.getUser_no());
        return new Result();
    }



    @Override
    public ResultPage<LineBook> getBookList(Book book, Page page) {
        PageHelper.startPage(page);
        List<LineBook> bookList = lineBookDao.getBookList(book);
        return new ResultPage<>(bookList);
    }

    @Override
    public LineBook toLineBookDetail(String bid) {
        LineBook lineBook = lineBookDao.getLineBookDetail(bid);
        return lineBook;
    }

    @Override
    public ResultPage<LineBook> getAuditBookList(Book book, Page page) {
        PageHelper.startPage(page);
        List<LineBook> lineBooks = lineBookDao.getAuditBookList(book);
        return new ResultPage<>(lineBooks);
    }

    /**
     * 意外保障费完成
     * @param bid
     * @return
     */
    @Override
    public Result completePay(String bid) throws Exception {
        LineBook lineBook = lineBookDao.getBaseBookInfo(bid);
        Integer leaseterm = Integer.valueOf(lineBook.getLeaseterm());
        String leaseterm_price = lineBook.getLeaseterm_price(); //每期的租金
        //从今日开始，生成每期费用
        List<Payment> payments = dealPayMents(lineBook.getBid(), leaseterm_price, leaseterm);
        lineBookDao.insertBookFee(payments);
        String repaydate = PublicUtil.getNextMonthDay(1); //下个月的今日进行还款
        User user = (User) session.getAttribute("user");
        lineBookDao.completePay(bid,  repaydate, user.getUser_no());

        //开始推送通知及其短信通知
        //插入到消息中
        LineBook lineBookDb = lineBookDao.getBookInfo(bid);
        String title = "审核完成";
        String msg = "尊敬的"+lineBookDb.getName()+"，您的订单号："+lineBookDb.getBook_no()+"已经开始发货，" +
                "产品序列号为:"+lineBookDb.getProduct_imei()+", 将通过顺丰发出，请您在签收时对比序列号，" +
                "如果不一致请拒绝签收，否则造成的损失将由您本人承担。";
        lineBookDao.insertNotify(title, msg, lineBookDb.getCustom_id(), user.getUser_no());

        //短信通知保障费支付完成
        Map<String, String> smsParams = new HashMap<>();
        smsParams.put("name", lineBookDb.getName());
        smsParams.put("book_no", lineBookDb.getBook_no());
        Result result = SendSmsUtil.send(lineBookDb.getPhone(), SmsConstant.TEMPLATE_OUTPUT, JSON.toJSONString(smsParams));
        if(result.getCode() == 0) {
            //说明短信发送失败
            return new Result(1, "审核操作已完成，通知短信发送失败："+result.getMessage()+"; 请联系管理员进行解决");
        }
        //加入操作记录
        lineBookDao.insertBookOperLog(bid, 2, "意外保障费", "已收取到意外保障费，确认收取人："+ user.getUsername(), user.getUser_no());
        return new Result();
    }

    @Override
    public Result unPassAudit(LineBook lineBook) throws Exception {
        User user = (User) session.getAttribute("user");
        lineBook.setAudit_user(user.getUser_no());
        lineBookDao.unPassAudit(lineBook);

        //插入到消息中
        LineBook lineBookDb = lineBookDao.getBookInfo(String.valueOf(lineBook.getBid()));
        String title = "审核完成";
        String msg = "尊敬的"+lineBookDb.getName()+"，您的订单号："+lineBookDb.getBook_no()+"审核未通过，请在我的订单中查看拒绝原因。";
        lineBookDao.insertNotify(title, msg, lineBookDb.getCustom_id(), user.getUser_no());

        //短信通知审核结果
        Map<String, String> smsParams = new HashMap<>();
        smsParams.put("name", lineBookDb.getName());
        smsParams.put("book_no", lineBookDb.getBook_no());
        Result result = SendSmsUtil.send(lineBookDb.getPhone(), SmsConstant.TEMPLATE_AUDIT, JSON.toJSONString(smsParams));
        if(result.getCode() == 0) {
            //说明短信发送失败
            return new Result(1, "审核操作已完成，通知短信发送失败："+result.getMessage()+"; 请联系管理员进行解决");
        }
        //加入操作记录
        lineBookDao.insertBookOperLog(String.valueOf(lineBook.getBid()), 3, "审核拒绝", "订单审核拒绝，审核人："+user.getUsername(), user.getUser_no());
        return new Result();
    }

    @Override
    public Result delBook(String ids) {
        lineBookDao.delBook(PublicUtil.toListByIds(ids));
        return new Result();
    }

    @Override
    public ResultPage getBanlanceBookList(LineBook lineBook, Page page) {
        PageHelper.startPage(page);
        List<LineBook> lineBookList = lineBookDao.getBanlanceBookList(lineBook);
        return new ResultPage(lineBookList);
    }

    @Override
    public Result finishBook(String bid) {
        User user = (User) session.getAttribute("user");
        lineBookDao.finishBook(bid);
        lineBookDao.finishBookBill(bid, user.getUser_no());
        //加入订单操作记录
        lineBookDao.insertBookOperLog(bid, 1,"结清订单", "内部系统手动结清订单，操作人："+user.getUsername(), user.getUser_no());
        return new Result();
    }

    @Override
    public Result getBill(String bid) {
        List<Payment> list = lineBookDao.getBill(bid);
        return new Result(1, "查询成功！", list);
    }


    private List<Payment> dealPayMents(Long book_id, String leaseterm_price, Integer leaseterm) {
        List<Payment> payments = new ArrayList<>();
        for (int i = 0; i < leaseterm; i++) {
            Payment payment = new Payment();
            payment.setCrtuser("系统");
            payment.setCurphase(i + 1);
            payment.setMoney(leaseterm_price);
            payment.setDate(PublicUtil.getNextMonthDay(i+1));
            payment.setBid(book_id);
            if(i == 0) {
                payment.setState(2);
            }else{
                payment.setState(4);
            }
            payments.add(payment);
        }
        return payments;
    }
}
