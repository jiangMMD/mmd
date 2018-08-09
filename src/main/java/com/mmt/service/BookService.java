package com.mmt.service;

import com.mmt.model.Book;
import com.mmt.model.Iemi;
import com.mmt.model.Iemi_turnover;
import com.mmt.model.Payment;
import com.mmt.pjo.Page;
import com.mmt.pjo.Result;
import com.mmt.pjo.ResultPage;

import java.util.Map;


public interface BookService {

    ResultPage<Book> getAuditBookList(Book book, Page page);

    Book getBookDetail(String id);

    Result passAudit(String id);

    Result unPassAudit(Book book);

    Result backUpdate(Book book);

    ResultPage<Book> getBookList(Book book, Page page);

    Result passReAudit(String id);

    Result unPassReAudit(Book book);

    Result backReUpdate(Book book);

    Result addOrUpdBook(Book book);

    int isImei(String imei);

    Result delBook(String ids);

    Result queryRepay(String bid);

    Result finishBook(String bid);

    Result updBookPact(Book book);

    ResultPage<Book> getoverDueBookList(Book book, Page page);

    Result queryRepayByBid(String bid);

    Result queryBookStateWithBid(String bid);

    Result finishBookFee(String bid, String pid, String boot_type);

    ResultPage getImeiInfo(Page page, Iemi iemi);

    Result updImeiInfo(Iemi iemi);

    void delImeiInfo(String id);

    Result addImeiInfo(Iemi iemi);

    ResultPage<Iemi_turnover> getOutImeiInfo(Page page, String imei_no, String agency_id);

    Result saveImeiInfo(Iemi_turnover iemi_turnover);

    ResultPage<Iemi_turnover> getInImeiInfo(Page page, String imei_no, String agency_id);

    Result delInImeiInfo(String ids);

    Result saveInImeiInfo(Iemi_turnover iemi_turnover);
}
