package com.mmt.dao;

import com.mmt.model.*;
import com.mmt.pjo.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BookDao {

    List<Book> getAuditBookList(Book book);

    Book getBookDetail(@Param("id") String id, @Param("user") User user);

    void passAudit(@Param("id") String id, @Param("user_no") String user_no);

    Book getBookState(@Param("id") String id);

    void unPassAudit(Book book);

    void backUpdate(Book book);

    List<Book> getBookList(Book book);

    void passReAudit(@Param("id") String id, @Param("user_no") String user_no,
                     @Param("expectDate") String expectDate, @Param("price") String price);

    void unPassReAudit(Book book);

    void backReUpdate(Book book);

    Book getBookFeeById(@Param("id") String id);

    void insertBookFee(@Param("payments") List<Payment> payments);

    void addCusLink(CusLink cusLink);

    int isImei(@Param("imei") String imei);

    void updCusLink(CusLink cusLink);

    void updateAccessory(Accessory accessory);

    void updateBook(Book book);

    void addAccessory(Accessory accessory);

    Long getMaxBookNo(Long bid);

    void addBook(Book book);

    void delBook(@Param("ids") List<String> ids);

    List<Payment> queryRepay(@Param("bid") String bid);

    void finishBook(@Param("bid") String bid, @Param("user_no") String user_no);

    void updBookPact(Book book);

    List<Book> queryBookWithPaid();

    void insertErrBookMsg(@Param("book_no") String book_no, @Param("errmsg") String errmsg);

    void setBookOverdueFee(Book book);

    void setBookRent(Book book);

    List<Book> getoverDueBookList(Book book);

    Payment getCurrRepayByBook(@Param("bid") Long bid, @Param("repaydate") String repaydate);

    void updateRaymentFee(Payment payment);

    List<Payment> queryRepayByBid(@Param("bid") String bid);

    Book queryBookStateWithBid(@Param("bid") String bid);

    void finishPamentFee(@Param("pid") String pid, @Param("user_no") String user_no);

    void finishBookFee(@Param("bid") String bid);

    Payment getPayment(@Param("bid") String bid);

    Book getBookRepaylssue(@Param("bid") String bid);

    void updBookByFee(@Param("bid") String bid);

    void insertBookFeeOperLog(@Param("bid") String bid, @Param("type") int type, @Param("desc") String desc, @Param("user_no") String user_no);

    void setPaymentState(@Param("bid") String bid, @Param("lssue") int lssue);

    Map<String,Object> getTest1();

    List<Iemi> getImeiInfo(Iemi iemi);

    void updImeiInfo(Iemi iemi);

    void delImeiInfo(@Param("id") String id);

    void addImeiInfo(Iemi iemi);

    int hasNotRayFee(@Param("bid") String bid, @Param("pid") String pid);

    List<Iemi_turnover> getOutImeiInfo(@Param("imei_no") String imei_no, @Param("agency_id") String agency_id);

    void saveImeiInfo(Iemi_turnover iemi_turnover);

    void updateImeiState(@Param("nos") List<String> nos);

    void updateImeiInfo(Iemi_turnover iemi_turnover);

    List<Iemi_turnover> getInImeiInfo(@Param("imei_no") String imei_no, @Param("agency_id") String agency_id);

    void delInImeiInfo(@Param("ids") List<String> ids);

    void delImeis(@Param("ids") List<String> ids);

    void saveInImeiInfo(Iemi_turnover iemi_turnover);

    void updateInImeiInfo(Iemi_turnover iemi_turnover);

    int getTurnover(@Param("imei_nos") List<String> imei_nos);

    List<Iemi> getTurnoverHasId(@Param("id") Long id, @Param("imei_nos") List<String> imei_nos);

    List<Map<String, Object>> imeiIsOutput(@Param("ids") List<String> ids);

    int queryCountByIemiNo(@Param("no") String no);

    int getImeiNoCount(@Param("imei_no") String imei_no);

    List<Book> getCurrBackBook();

    void updateFeeWithSms(@Param("bid") Long bid);

    void insertSmsLog(@Param("bid") Long bid, @Param("state") int state, @Param("content") String content);
}
