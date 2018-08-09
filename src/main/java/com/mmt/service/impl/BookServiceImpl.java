package com.mmt.service.impl;

import com.github.pagehelper.PageHelper;
import com.mmt.dao.BookDao;
import com.mmt.model.*;
import com.mmt.pjo.Page;
import com.mmt.pjo.Result;
import com.mmt.pjo.ResultPage;
import com.mmt.service.BookService;
import com.mmt.utils.PublicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private HttpSession session;

    @Override
    public ResultPage<Book> getAuditBookList(Book book, Page page) {
        PageHelper.startPage(page);
        book.setUser((User) session.getAttribute("user"));
        List<Book> bookList = bookDao.getAuditBookList(book);
        return new ResultPage<>(bookList);
    }

    @Override
    public Book getBookDetail(String id) {
        return bookDao.getBookDetail(id, (User) session.getAttribute("user"));
    }

    @Override
    public Result passAudit(String id) {
        Book book = bookDao.getBookState(id);
        if (Objects.equals(book.getState(), 4)) {
            return new Result(0, "操作失败！该订单状态已经发生改变，请尝试返回刷新列表，在进行操作");
        }
        User user = (User) session.getAttribute("user");
        bookDao.passAudit(id, user.getUser_no());
        return new Result();
    }

    @Override
    public Result unPassAudit(Book book) {
        Book bookWithDb = bookDao.getBookState(String.valueOf(book.getBid()));
        if (Objects.equals(bookWithDb.getState(), 4)) {
            return new Result(0, "操作失败！该订单状态已经发生改变，请尝试返回刷新列表，在进行操作");
        }
        User user = (User) session.getAttribute("user");
        book.setAudituser(user.getUser_no());
        bookDao.unPassAudit(book);
        return new Result();
    }

    @Override
    public Result backUpdate(Book book) {
        Book bookWithDb = bookDao.getBookState(String.valueOf(book.getBid()));
        if (Objects.equals(bookWithDb.getState(), 4)) {
            return new Result(0, "操作失败！该订单状态已经发生改变，请尝试返回刷新列表，在进行操作");
        }
        User user = (User) session.getAttribute("user");
        book.setAudituser(user.getUser_no());
        bookDao.backUpdate(book);
        return new Result();
    }

    @Override
    public ResultPage<Book> getBookList(Book book, Page page) {
        PageHelper.startPage(page);
        book.setUser((User) session.getAttribute("user"));
        List<Book> bookList = bookDao.getBookList(book);
        return new ResultPage<>(bookList);
    }

    @Override
    public Result passReAudit(String id) {
        Book book = bookDao.getBookState(id);
        if (Objects.equals(book.getState(), 4)) {
            return new Result(0, "操作失败！该订单状态已经发生改变，请尝试返回刷新列表，在进行操作");
        }
        User user = (User) session.getAttribute("user");
        //从今日开始，开始生成费用信息
        Book bookWithFee = bookDao.getBookFeeById(id);
        List<Payment> payments = dealPayMents(bookWithFee, user.getUser_no());
        payments.get(0).setState(2);
        //设置下次还款日期
        bookDao.insertBookFee(payments);
        String expectDate = PublicUtil.getAssignDate(7); //每期为7天
        bookDao.passReAudit(id, user.getUser_no(), expectDate, bookWithFee.getMonthrent());
        return new Result();
    }

    private List<Payment> dealPayMents(Book bookWithFee, String crtuser) {
        List<Payment> payments = new ArrayList<>();
        Integer leaseterm = Integer.valueOf(bookWithFee.getLeaseterm());
        String price = bookWithFee.getMonthrent();
        for (int i = 0; i < leaseterm; i++) {
            Payment payment = new Payment();
            payment.setCrtuser(crtuser);
            payment.setCurphase(i + 1);
            payment.setMoney(price);
            payment.setDate(PublicUtil.getAssignDate((i + 1) * 7));
            payment.setBid(bookWithFee.getBid());
            payment.setState(4);
            payments.add(payment);
        }
        return payments;
    }

    @Override
    public Result unPassReAudit(Book book) {
        Book bookWithDb = bookDao.getBookState(String.valueOf(book.getBid()));
        if (Objects.equals(bookWithDb.getState(), 4)) {
            return new Result(0, "操作失败！该订单状态已经发生改变，请尝试返回刷新列表，在进行操作");
        }
        User user = (User) session.getAttribute("user");
        book.setReaudituser(user.getUser_no());
        bookDao.unPassReAudit(book);
        return new Result();
    }

    @Override
    public Result backReUpdate(Book book) {
        Book bookWithDb = bookDao.getBookState(String.valueOf(book.getBid()));
        if (Objects.equals(bookWithDb.getState(), 4)) {
            return new Result(0, "操作失败！该订单状态已经发生改变，请尝试返回刷新列表，在进行操作");
        }
        User user = (User) session.getAttribute("user");
        book.setReaudituser(user.getUser_no());
        bookDao.backReUpdate(book);
        return new Result();
    }

    @Override
    public Result addOrUpdBook(Book book) {
        if(book.getBid() != null) {
            //修改
            return updBook(book);
        }else{
            return addBook(book);
        }
    }

    @Override
    public int isImei(String imei) {
        return bookDao.isImei(imei);
    }

    @Override
    public Result delBook(String ids) {
        bookDao.delBook(PublicUtil.toListByIds(ids));
        return new Result();
    }

    @Override
    public Result queryRepay(String bid) {
        List<Payment> payments =  bookDao.queryRepay(bid);
        return new Result(1, "查询成功！", payments);
    }

    @Override
    public Result finishBook(String bid) {
        User user = (User) session.getAttribute("user");
        bookDao.finishBook(bid, user.getUser_no());
        return new Result(1, "操作成功！");
    }

    @Override
    public Result updBookPact(Book book) {
        bookDao.updBookPact(book);
        return new Result();
    }

    @Override
    public ResultPage<Book> getoverDueBookList(Book book, Page page) {
        PageHelper.startPage(page);
        book.setUser((User) session.getAttribute("user"));
        List<Book> bookList = bookDao.getoverDueBookList(book);
        return new ResultPage<>(bookList);
    }

    @Override
    public Result queryRepayByBid(String bid) {
        List<Payment> payments =  bookDao.queryRepayByBid(bid);
        return new Result(1, "查询成功！", payments);
    }

    @Override
    public Result queryBookStateWithBid(String bid) {
        Book book = bookDao.queryBookStateWithBid(bid);
        return new Result(1, "查询成功！", book);
    }

    @Override
    public Result finishBookFee(String bid, String pid, String boot_type) {
        User user = (User) session.getAttribute("user");
        bookDao.finishPamentFee(pid, user.getUser_no());
        //结清该期订单费用
        if(Objects.equals(boot_type, "1")) {
            //如果是由租转售， 那么就直接完结该订单
            bookDao.finishBookFee(bid);
            //操作记录，
            bookDao.insertBookFeeOperLog(bid, 1, "结算订单（由租转售订单结算所有费用）",  user.getUser_no());
        }else{
            //查看之前期的费用是否有未还状态
            int notPayNum = bookDao.hasNotRayFee(bid, pid);
            if(notPayNum > 0) {
                return new Result(0, "该订单当期之前尚有未结算的还款期。 请先结清之前的还款期，在结算当前期");
            }
            //出租的话，那么判断是否是最后一期， 如果是最后一期，那么就结清该订单
            Payment payment = bookDao.getPayment(bid);
            Integer last = payment.getCurphase();
            Book repaylssueBook = bookDao.getBookRepaylssue(bid);
            //当前已还多少期？
            Integer lssue = repaylssueBook.getRepaylssue() != null ? Integer.valueOf(repaylssueBook.getRepaylssue()) : 0;
            System.out.println("lssue:"+lssue);
            System.out.println("last:"+last);
            if(last.equals(lssue + 1)) {
                //说明是最后一期，订单完结
                bookDao.finishBookFee(bid);
                bookDao.insertBookFeeOperLog(bid, 1, "结算第"+lssue+"期订单",  user.getUser_no());
            }else{
                //说明不是最后一期， 订单变为待还
                bookDao.updBookByFee(bid);
                //设置下一期为待还状态
                bookDao.setPaymentState(bid, lssue + 2);
                bookDao.insertBookFeeOperLog(bid, 1, "结算订单（由租转售订单结算所有费用）",  user.getUser_no());
            }
        }
        return new Result();
    }

    @Override
    public ResultPage getImeiInfo(Page page, Iemi iemi) {
        PageHelper.startPage(page);
        List<Iemi> list = bookDao.getImeiInfo(iemi);
        return new ResultPage(list);
    }

    @Override
    public Result updImeiInfo(Iemi iemi) {
        bookDao.updImeiInfo(iemi);
        return new Result();
    }

    @Override
    public void delImeiInfo(String id) {
        bookDao.delImeiInfo(id);
    }

    @Override
    public Result addImeiInfo(Iemi iemi) {
        User user = (User) session.getAttribute("user");
        iemi.setCrtuser(user.getUser_no());
        bookDao.addImeiInfo(iemi);
        return new Result();
    }

    @Override
    public ResultPage<Iemi_turnover> getOutImeiInfo(Page page, String imei_no, String agency_id) {
        PageHelper.startPage(page);
        return new ResultPage<Iemi_turnover>(bookDao.getOutImeiInfo(imei_no, agency_id));
    }

    @Override
    public Result saveImeiInfo(Iemi_turnover iemi_turnover) {
        User user = (User) session.getAttribute("user");
        iemi_turnover.setCrtuser(user.getUser_no());
        if(iemi_turnover.getId() != null) {
            bookDao.updateImeiInfo(iemi_turnover);
        }else{
            bookDao.saveImeiInfo(iemi_turnover);
        }
        bookDao.updateImeiState(PublicUtil.toListByIds(iemi_turnover.getImei_nos()));
        return new Result();
    }

    @Override
    public ResultPage<Iemi_turnover> getInImeiInfo(Page page, String imei_no, String agency_id) {
        PageHelper.startPage(page);
        return new ResultPage<Iemi_turnover>(bookDao.getInImeiInfo(imei_no, agency_id));
    }

    @Override
    public Result delInImeiInfo(String ids) {
        //判断该商品是否已经出库，如果已出库，那么就不让继续删除
        List<Map<String, Object>> mapList = bookDao.imeiIsOutput(PublicUtil.toListByIds(ids));
        Set<Object> nos = PublicUtil.toSingSet(mapList, "imei_nos");
        for (Object no : nos) {
            int count = bookDao.queryCountByIemiNo(String.valueOf(no));
            if(count > 0) {
                return  new Result(0, "IMEI号为："+no+"，已经出库（发货给代理商），无法执行删除操作，如果需要删除，请先至商品出库列表，找到该IMEI号进行删除或修改操作");
            }
        }
        //删除入货信息
        bookDao.delInImeiInfo(PublicUtil.toListByIds(ids));
        //删除列表信息
        bookDao.delImeis(PublicUtil.toListByIds(ids));
        return new Result();
    }

    /**
     * 入库单
     * @param iemi_turnover
     * @return
     */
    @Override
    public Result saveInImeiInfo(Iemi_turnover iemi_turnover){
        User user = (User) session.getAttribute("user");
        iemi_turnover.setCrtuser(user.getUser_no());
        //查询录入的是否有重复
        if(iemi_turnover.getId() != null) {
            List<Iemi> iemis = bookDao.getTurnoverHasId(iemi_turnover.getId(), PublicUtil.toListByIds(iemi_turnover.getImei_nos()));
            if(iemis != null && iemis.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (Iemi iemi : iemis) {
                    sb.append(",");
                    sb.append(iemi.getImei_no());
                }
                return new Result(0, "IMEI号重复；以下为重复号："+ sb.substring(1));
            }

            bookDao.updateInImeiInfo(iemi_turnover);
        }else{
            int count = bookDao.getTurnover(PublicUtil.toListByIds(iemi_turnover.getImei_nos()));
            if(count > 0) {
                return new Result(0, "IMEI号重复，请确保该IMEI号没有录入过");
            }
            bookDao.saveInImeiInfo(iemi_turnover);
        }

        String imei_nos = iemi_turnover.getImei_nos();
        for (String imei_no : PublicUtil.toListByIds(imei_nos)) {
            Iemi iemi = new Iemi();
            iemi.setProduct_name(iemi_turnover.getProduct_name());
            iemi.setImei_no(imei_no);
            int count = bookDao.getImeiNoCount(imei_no);
            if(count == 0) {
                bookDao.addImeiInfo(iemi);
            }
        }
//        bookDao.updateImeiState(PublicUtil.toListByIds(iemi_turnover.getImei_nos()));
        return new Result();
    }


    private Result updBook(Book book) {
        User user = (User) session.getAttribute("user");
        //联系人信息
        List<CusLink> cusList = book.getCusLinkList();
        StringBuilder link_ids = new StringBuilder();
        for (CusLink cusLink : cusList) {
            cusLink.setUpduser(user.getUser_no());
            if(cusLink.getLid() == null) {
                bookDao.addCusLink(cusLink);
            }else{
                bookDao.updCusLink(cusLink);
            }
            link_ids.append(",");
            link_ids.append(String.valueOf(cusLink.getLid()));
        }
        book.setLink_ids(link_ids.substring(1));

        //保存附件信息
        Accessory accessory = book.getAccessory();
        accessory.setYid(book.getAccessory_id());
        accessory.setUpduser(user.getUser_no());
        bookDao.updateAccessory(accessory);
        book.setAccessory_id(accessory.getYid());
        book.setCrtuser(user.getUser_no());
        bookDao.updateBook(book);
        return new Result();

    }

    private Result addBook(Book book) {
        User user = (User) session.getAttribute("user");
        //联系人信息
        List<CusLink> cusList = book.getCusLinkList();
        StringBuilder link_ids = new StringBuilder();
        for (CusLink cusLink : cusList) {
            cusLink.setCrtuser(user.getUser_no());
            bookDao.addCusLink(cusLink);
            link_ids.append(",");
            link_ids.append(String.valueOf(cusLink.getLid()));
        }
        book.setLink_ids(link_ids.substring(1));
        //保存附件信息
        Accessory accessory = book.getAccessory();
        accessory.setCrtuser(user.getUser_no());
        bookDao.addAccessory(accessory);
        book.setAccessory_id(accessory.getYid());
        book.setCrtuser(user.getUser_no());
        //设置订单号
        Long bookId = bookDao.getMaxBookNo(book.getBid());
        String book_no = "";
        if (bookId == null) {
            bookId = 1L;
        }
        bookId = bookId + 1;
        if (bookId < 10000) {
            int pre = 4 - String.valueOf(bookId).length();
            book_no = "XXZ" + pre + bookId;
        }else{
            book_no = "XXZ" + bookId;
        }
        book.setBook_no(book_no);
        bookDao.addBook(book);
        return new Result();
    }
}
