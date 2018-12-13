package com.mmd.service.impl;

import com.github.pagehelper.PageHelper;
import com.mmd.dao.BookDao;
import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;
import com.mmd.service.BookService;
import com.mmd.utils.PublicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
     private BookDao bookDao;

    @Override
    public ResultPage getBookList(Page page, Map<String, String> params) {
        PageHelper.startPage(page);
        List<Map<String, Object>> list = bookDao.getBookList(params) ;
        return new ResultPage<>(list);
    }

    @Override
    public Result delBook(String ids) {
        bookDao.delBook(PublicUtil.toListByIds(ids));
        return new Result();
    }
}
