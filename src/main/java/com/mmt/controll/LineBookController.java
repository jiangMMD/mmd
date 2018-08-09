package com.mmt.controll;

import com.mmt.model.Book;
import com.mmt.model.Custom;
import com.mmt.model.LineBook;
import com.mmt.pjo.Page;
import com.mmt.pjo.Result;
import com.mmt.pjo.ResultPage;
import com.mmt.service.LineBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 线上订单控制器
 */
@Controller
@RequestMapping("/linebook")
public class LineBookController {

    @Autowired
    private LineBookService lineBookService;


    @RequestMapping("/getBookList")
    public @ResponseBody ResultPage<LineBook> getBookList(Book book, Page page) {
        return lineBookService.getBookList(book,  page);
    }

    @RequestMapping("/toLineBookDetail")
    public @ResponseBody
    ModelAndView toLineBookDetail(String bid) {
        LineBook lineBook = lineBookService.toLineBookDetail(bid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("linebook", lineBook);
        modelAndView.setViewName("../content/bookline/bookdetail.jsp");
        return modelAndView;
    }

    @RequestMapping("/getAuditBookList")
    public @ResponseBody ResultPage<LineBook> getAuditBookList(Book book, Page page) {
        return lineBookService.getAuditBookList(book,  page);
    }

    @RequestMapping("/toLineBookAuditDet")
    public @ResponseBody ModelAndView toLineBookAuditDet(String bid) {
        LineBook lineBook = lineBookService.toLineBookDetail(bid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("linebook", lineBook);
        modelAndView.setViewName("../content/bookline/bookauditdet.jsp");
        return modelAndView;
    }

    /**
     * 审核通过
     * @param bid
     * @return
     */
    @RequestMapping("/passAudit")
    public @ResponseBody
    Result passAudit(String bid) throws Exception {
        return lineBookService.passBookAudit(bid);
    }

    /**
     * 完成打款
     */
    @RequestMapping("/completePay")
    public @ResponseBody Result completePay(String bid) throws Exception {
        return lineBookService.completePay(bid);
    }

    /**
     * 审核拒绝
     */
    @RequestMapping("/unPassAudit")
    public @ResponseBody Result unPassAudit(LineBook lineBook) throws Exception {
        return lineBookService.unPassAudit(lineBook);
    }

    /**
     * 删除订单
     */
    @RequestMapping("/delBook")
    public @ResponseBody Result delBook(String ids) {
        return lineBookService.delBook(ids);
    }

    /**
     * 查询已生成费用订单信息
     */
    @RequestMapping("/getBanlanceBookList")
    public @ResponseBody ResultPage getBanlanceBookList(LineBook lineBook, Page page) {
        return lineBookService.getBanlanceBookList(lineBook, page);
    }

    /**
     * 完结订单
     */
    @RequestMapping("/finishBook")
    public @ResponseBody Result finishBook(String bid) {
        return lineBookService.finishBook(bid);
    }

    /**
     * 查询账单
     */
    @RequestMapping("/getBill")
    public @ResponseBody Result getBill(String bid) {
        return lineBookService.getBill(bid);
    }
}
