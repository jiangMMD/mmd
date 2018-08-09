package com.mmt.dao;

import com.mmt.model.Book;
import com.mmt.model.LineBook;
import com.mmt.model.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LineBookDao {

    LineBook getBaseBookInfo(@Param("bid") String bid);

    void insertBookFee(@Param("payments") List<Payment> payments);

    void passAudit(@Param("bid") String bid, @Param("user_no") String user_no);

    List<LineBook> getBookList(Book book);

    LineBook getLineBookDetail(@Param("bid") String bid);

    List<LineBook> getAuditBookList(Book book);

    void unPassAudit(LineBook lineBook);

    void completePay(@Param("bid") String bid, @Param("repaydate") String repaydate, @Param("user_no") String user_no);

    void delBook(@Param("ids") List<String> ids);

    LineBook getBookInfo(@Param("bid") String bid);

    void insertNotify(@Param("title") String title, @Param("msg") String msg,
                      @Param("custom_id") Long custom_id, @Param("crtuser") String crtuser);

    List<LineBook> getBanlanceBookList(LineBook lineBook);

    void finishBook(@Param("bid") String bid);

    void insertBookOperLog(@Param("bid") String bid, @Param("oper_type") int oper_type, @Param("oper_title") String oper_title, @Param("oper_content") String oper_content, @Param("user_no") String user_no);

    void finishBookBill(@Param("bid") String bid, @Param("user_no") String user_no);

    List<Payment> getBill(@Param("bid") String bid);

    List<LineBook> queryBookWithPaid();

    void insertErrBookMsg(@Param("book_no") String book_no, @Param("errmsg") String errmsg);

    void setBookOverdueFee(LineBook lineBook);

    void setBookRent(LineBook lineBook);

    Payment getCurrRepayByBook(@Param("bid") Long bid, @Param("repaydate") String repaydate);

    void updateRaymentFee(Payment payment);
}
