package com.mmd.service;

import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;

import java.util.Map;

public interface BookService {

    ResultPage getBookList(Page page, Map<String, String> params);

    Result delBook(String ids);
}
