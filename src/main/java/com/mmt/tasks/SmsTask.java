package com.mmt.tasks;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.exceptions.ClientException;
import com.mmt.constant.SmsConstant;
import com.mmt.dao.BookDao;
import com.mmt.model.Book;
import com.mmt.pjo.Result;
import com.mmt.utils.PropertyLoad;
import com.mmt.utils.PublicUtil;
import com.mmt.utils.SendSmsUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 短信业务， 定时发送短信通知客户缴纳本期租金
 */
@Component
@Transactional
public class SmsTask {

    private static final Log log = LogFactory.getLog(SmsTask.class);

    @Autowired
    private BookDao bookDao;


    @Scheduled(cron = "0 0 8 * * *")
    public void task() {
        log.info("开始发送短信.................");
        //查询所有今日待还的订单
        List<Book> bookList = bookDao.getCurrBackBook();
        if(bookList == null) {
            return;
        }
        for (Book book : bookList) {
            String phone = book.getPhone();
            Map<String, Object> params = new HashMap<>();
            params.put("name", book.getName());
            params.put("book_no", book.getBook_no());
            params.put("time", PublicUtil.getDate("yyyy-MM-dd"));
            params.put("money", book.getRepaytotal());
            try {
                Result result = SendSmsUtil.send(phone, SmsConstant.TEMPLATE_RENT, JSON.toJSONString(params));
                if(result.getCode() == 1) {
                    //说明发送成功； 那么设置费用列表，当前短信已发送
                    bookDao.updateFeeWithSms(book.getBid());
                    bookDao.insertSmsLog(book.getBid(), 1, "发送成功");
                }else{
                    bookDao.insertSmsLog(book.getBid(), 1, result.getMessage());
                }
            } catch (ClientException e) {
                log.error(e);
                bookDao.insertSmsLog(book.getBid(), 2, "短信发送失败；本地服务器出现异常！");
            }
        }
        log.info("短信发送任务执行结束................");
    }

}
