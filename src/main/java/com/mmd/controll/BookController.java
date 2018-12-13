package com.mmd.controll;

import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;
import com.mmd.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/getBookList")
    public @ResponseBody ResultPage getBookList(Page page, @RequestParam Map<String, String> params){
        return bookService.getBookList(page,params);
    }

    @RequestMapping("/delBook")
    public @ResponseBody Result delBook(String ids) {
        return bookService.delBook(ids);
    }

}
