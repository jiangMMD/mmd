package com.mmt.service;

import com.aliyuncs.exceptions.ClientException;
import com.mmt.model.Book;
import com.mmt.model.Custom;
import com.mmt.model.LineBook;
import com.mmt.pjo.Page;
import com.mmt.pjo.Result;
import com.mmt.pjo.ResultPage;
import org.springframework.beans.factory.annotation.Autowired;

public interface LineBookService {

    Result passBookAudit(String bid) throws ClientException, Exception;

    ResultPage<LineBook> getBookList(Book book, Page page);

    LineBook toLineBookDetail(String bid);

    ResultPage<LineBook> getAuditBookList(Book book, Page page);

    Result completePay(String bid) throws ClientException, Exception;

    Result unPassAudit(LineBook lineBook) throws ClientException, Exception;

    Result delBook(String ids);

    ResultPage getBanlanceBookList(LineBook lineBook, Page page);

    Result finishBook(String bid);

    Result getBill(String bid);
}
