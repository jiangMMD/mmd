package com.mmt.controll;

import com.mmt.model.*;
import com.mmt.pjo.Page;
import com.mmt.pjo.Result;
import com.mmt.pjo.ResultPage;
import com.mmt.service.BookService;
import com.mmt.utils.PropertyLoad;
import com.mmt.utils.PublicUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;


@Controller
@RequestMapping("/book")
public class BookControll {

    @Autowired
    private BookService bookService;

    @Autowired
    private HttpSession session;

    /**
     * 查询待审核订单
     * @return
     */
    @RequestMapping("/getAuditBookList")
    public @ResponseBody
    ResultPage<Book> getAuditBookList(Book book, Page page) {
        return bookService.getAuditBookList(book, page);
    }

    @RequestMapping("/toBookAuditDetail")
    public ModelAndView toBookAuditDetail(String id) {
        ModelAndView modelAndView = new ModelAndView();
        Book book = bookService.getBookDetail(id);
        if(book == null) {
            modelAndView.setViewName("../content/common/error-403.html");
        }else{
            modelAndView.addObject("book", book);
            modelAndView.setViewName("../content/book/bookauditdet.jsp");
        }
        return modelAndView;
    }

    @RequestMapping("/passAudit")
    public @ResponseBody
    Result passAudit(String id) {
        return bookService.passAudit(id);
    }

    @RequestMapping("/unPassAudit")
    public @ResponseBody
    Result unPassAudit(Book book) {
        return bookService.unPassAudit(book);
    }

    @RequestMapping("/backUpdate")
    public @ResponseBody
    Result backUpdate(Book book) {
        return bookService.backUpdate(book);
    }

    @RequestMapping("/passReAudit")
    public @ResponseBody
    Result passReAudit(String id) {
        return bookService.passReAudit(id);
    }

    @RequestMapping("/unPassReAudit")
    public @ResponseBody
    Result unPassReAudit(Book book) {
        return bookService.unPassReAudit(book);
    }

    @RequestMapping("/backReUpdate")
    public @ResponseBody
    Result backReUpdate(Book book) {
        return bookService.backReUpdate(book);
    }

    @RequestMapping("/getBookList")
    public @ResponseBody ResultPage<Book> getBookList(Book book, Page page) {
        return bookService.getBookList(book, page);
    }

    @RequestMapping("/toBookDetail")
    public ModelAndView toBookDetail(String id) {
        ModelAndView modelAndView = new ModelAndView();
        Book book = bookService.getBookDetail(id);
        modelAndView.addObject("book", book);
        modelAndView.setViewName("../content/book/bookdetail.jsp");
        return modelAndView;
    }

    @RequestMapping("/toBookQueryDetail")
    public ModelAndView toBookQueryDetail(String id) {
        ModelAndView modelAndView = new ModelAndView();
        Book book = bookService.getBookDetail(id);
        modelAndView.addObject("book", book);
        modelAndView.setViewName("../content/book/bookquerydetail.jsp");
        return modelAndView;
    }

    @RequestMapping("/saveBookInfo")
    public @ResponseBody
    Result svaeBookInfo(MultipartFile identity_front, MultipartFile identity_reverse, MultipartFile identity_inhand,
                        MultipartFile work_card, MultipartFile staff_photo, MultipartFile bank_card, MultipartFile taobao_address,
                        MultipartFile zhifb_zmf, MultipartFile memo_one, MultipartFile memo_two,
                        Book book, @RequestParam Map<String, String> params) throws IOException {
        String imei = book.getProduct_imei();
        //查询imei 是否存在
        int count = bookService.isImei(imei);
        if (count == 0) {
            return new Result(0, "IMEI号不存在,请确保输入正确的IMEI号");
        }
        User user = (User) session.getAttribute("user");
        String uid = String.valueOf(user.getUid());
        Accessory accessory = new Accessory();
        if(identity_front != null && !identity_front.isEmpty()) {
            accessory.setIdentity_front(dealFile(uid, identity_front, "identity_front"));
        }
        if(identity_reverse != null && !identity_reverse.isEmpty()) {
            accessory.setIdentity_reverse(dealFile(uid, identity_reverse, "identity_reverse"));
        }
        if(identity_inhand != null && !identity_inhand.isEmpty()) {
            accessory.setIdentity_inhand(dealFile(uid, identity_inhand, "identity_inhand"));
        }
        if(work_card != null && !work_card.isEmpty()) {
            accessory.setWork_card(dealFile(uid, work_card, "work_card"));
        }
        if(staff_photo != null && !staff_photo.isEmpty()) {
            accessory.setStaff_photo(dealFile(uid, staff_photo, "staff_photo"));
        }
        if(bank_card != null && !bank_card.isEmpty()) {
            accessory.setBank_card(dealFile(uid, bank_card, "bank_card"));
        }
        if(taobao_address != null && !taobao_address.isEmpty()) {
            accessory.setTaobao_address(dealFile(uid, taobao_address, "taobao_address"));
        }
        if(zhifb_zmf != null && !zhifb_zmf.isEmpty()) {
            accessory.setZhifb_zmf(dealFile(uid, zhifb_zmf, "zhifb_zmf"));
        }
        if(memo_one != null && !memo_one.isEmpty()) {
            accessory.setMemo_one(dealFile(uid, memo_one, "memo_one"));
        }
        if(memo_two != null && !memo_two.isEmpty()) {
            accessory.setMemo_two(dealFile(uid, memo_two, "memo_two"));
        }
        book.setAccessory(accessory);
        //处理联系人信息
        dealLinkInfo(book, params);
        return bookService.addOrUpdBook(book);
    }

    private void dealLinkInfo(Book book, Map<String, String> params) {
        List<CusLink> cusLinks = new ArrayList<>();
        CusLink cusLink1 = new CusLink(StringUtils.isEmpty(params.get("lid1"))?null:Long.valueOf(params.get("lid1")), PublicUtil.mapValToString(params.get("lname1")),
                PublicUtil.mapValToString(params.get("lsex1")),
                PublicUtil.mapValToString(params.get("lrelation1")),
                PublicUtil.mapValToString(params.get("lphone1")),
                PublicUtil.mapValToString(params.get("lmemo1")));
        CusLink cusLink2 = new CusLink(StringUtils.isEmpty(params.get("lid2"))?null:Long.valueOf(params.get("lid2")), PublicUtil.mapValToString(params.get("lname2")),
                PublicUtil.mapValToString(params.get("lsex2")),
                PublicUtil.mapValToString(params.get("lrelation2")),
                PublicUtil.mapValToString(params.get("lphone2")),
                PublicUtil.mapValToString(params.get("lmemo2")));
        cusLinks.add(cusLink1);
        cusLinks.add(cusLink2);
        if (!StringUtils.isEmpty(params.get("lname3")) || !StringUtils.isEmpty(params.get("lphone3"))) {
            CusLink cusLink3 = new CusLink(StringUtils.isEmpty(params.get("lid3"))?null:Long.valueOf(params.get("lid3")), PublicUtil.mapValToString(params.get("lname3")),
                    PublicUtil.mapValToString(params.get("lsex3")),
                    PublicUtil.mapValToString(params.get("lrelation3")),
                    PublicUtil.mapValToString(params.get("lphone3")),
                    PublicUtil.mapValToString(params.get("lmemo3")));
            cusLinks.add(cusLink3);
        }
        if (!StringUtils.isEmpty(params.get("lname4")) || !StringUtils.isEmpty(params.get("lphone4"))) {
            CusLink cusLink4 = new CusLink(StringUtils.isEmpty(params.get("lid4"))?null:Long.valueOf(params.get("lid4")), PublicUtil.mapValToString(params.get("lname4")),
                    PublicUtil.mapValToString(params.get("lsex4")),
                    PublicUtil.mapValToString(params.get("lrelation4")),
                    PublicUtil.mapValToString(params.get("lphone4")),
                    PublicUtil.mapValToString(params.get("lmemo4")));
            cusLinks.add(cusLink4);
        }
        if (!StringUtils.isEmpty(params.get("lname5")) || !StringUtils.isEmpty(params.get("lphone5"))) {
            CusLink cusLink5 = new CusLink(StringUtils.isEmpty(params.get("lid5"))?null:Long.valueOf(params.get("lid5")), PublicUtil.mapValToString(params.get("lname5")),
                    PublicUtil.mapValToString(params.get("lsex5")),
                    PublicUtil.mapValToString(params.get("lrelation5")),
                    PublicUtil.mapValToString(params.get("lphone5")),
                    PublicUtil.mapValToString(params.get("lmemo5")));
            cusLinks.add(cusLink5);
        }
        if (!StringUtils.isEmpty(params.get("lname6")) || !StringUtils.isEmpty(params.get("lphone6"))) {
            CusLink cusLink6 = new CusLink(StringUtils.isEmpty(params.get("lid6"))?null:Long.valueOf(params.get("lid6")), PublicUtil.mapValToString(params.get("lname6")),
                    PublicUtil.mapValToString(params.get("lsex6")),
                    PublicUtil.mapValToString(params.get("lrelation6")),
                    PublicUtil.mapValToString(params.get("lphone6")),
                    PublicUtil.mapValToString(params.get("lmemo6")));
            cusLinks.add(cusLink6);
        }
        book.setCusLinkList(cusLinks);
    }

    private String dealFile(String aid, MultipartFile file, String typename) throws IOException {
        if (file == null) {
            return null;
        }
        String file_sourcename = file.getOriginalFilename();
        String ref = file_sourcename.substring(file_sourcename.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString().replaceAll("_", "").substring(0, 8);
        //生成文件名称
        String date = PublicUtil.getDate("yyyy-MM-dd");
        String filename = date + "_" + aid + "_user_" + typename + "_" + uuid + ref;
        String dir = PropertyLoad.getProperty("book_accessory_dir");
        File dirFile = new File(dir);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        File bookFile = new File(dir + File.separator + filename);
        file.transferTo(bookFile);
        return filename;
    }

    @RequestMapping("/delBook")
    public @ResponseBody Result delBook(String ids) {
        return bookService.delBook(ids);
    }

    @RequestMapping("/queryRepay")
    public @ResponseBody Result queryRepay(String bid) {
        return bookService.queryRepay(bid);
    }

    @RequestMapping("/queryRepayByBid")
    public @ResponseBody Result queryRepayByBid(String bid) {
        return bookService.queryRepayByBid(bid);
    }

    @RequestMapping("/finishBook")
    public @ResponseBody Result finishBook(String bid) {
        return bookService.finishBook(bid);
    }

    @RequestMapping("/updBookPact")
    public @ResponseBody Result updBookPact(Book book) {
        return bookService.updBookPact(book);
    }

    @RequestMapping("/getoverDueBookList")
    public @ResponseBody ResultPage<Book> getoverDueBookList(Book book, Page page) {
        return bookService.getoverDueBookList(book, page);
    }

    @RequestMapping("/queryBookStateWithBid")
    public @ResponseBody Result queryBookStateWithBid(String bid) {
        return bookService.queryBookStateWithBid(bid);
    }

    @RequestMapping("/finishBookFee")
    public @ResponseBody Result finishBookFee(String bid, String pid, String boot_type) {
        return bookService.finishBookFee(bid, pid, boot_type);
    }

    @RequestMapping("/toOverdueBookDetail")
    public ModelAndView toOverdueBookDetail(String id) {
        ModelAndView modelAndView = new ModelAndView();
        Book book = bookService.getBookDetail(id);
        modelAndView.addObject("book", book);
        modelAndView.setViewName("../content/book/overduebookdet.jsp");
        return modelAndView;
    }

    @RequestMapping("/getImeiInfo")
    public @ResponseBody ResultPage getImeiInfo(Page page, Iemi iemi) {
        return bookService.getImeiInfo(page, iemi);
    }

    @RequestMapping("/CRUD_ImeiInfo")
    public @ResponseBody Result CRUD_ImeiInfo(String oper, String id, Iemi iemi) {
        if(Objects.equals(oper, "edit")) {
            //修改操作
            return bookService.updImeiInfo(iemi);
        }else if(Objects.equals(oper, "del")) {
            //删除操作
            bookService.delImeiInfo(id);
        }else if(Objects.equals(oper, "add")){
            return bookService.addImeiInfo(iemi);
        }else{
            return new Result(0, "参数异常，操作失败！");
        }
        return new Result();
    }

    @RequestMapping("getOutImeiInfo")
    public @ResponseBody ResultPage<Iemi_turnover> getOutImeiInfo(Page page, String imei_no, String agency_id) {
        return bookService.getOutImeiInfo(page, imei_no, agency_id);
    }

    @RequestMapping("getInImeiInfo")
    public @ResponseBody ResultPage<Iemi_turnover> getInImeiInfo(Page page, String imei_no, String agency_id) {
        return bookService.getInImeiInfo(page, imei_no, agency_id);
    }

    @RequestMapping("saveImeiInfo")
    public @ResponseBody Result saveImeiInfo(Iemi_turnover iemi_turnover) {
        return bookService.saveImeiInfo(iemi_turnover);
    }

    @RequestMapping("delInImeiInfo")
    public @ResponseBody Result delInImeiInfo(String ids) {
        return bookService.delInImeiInfo(ids);
    }

    @RequestMapping("saveInImeiInfo")
    public @ResponseBody Result saveInImeiInfo(Iemi_turnover iemi_turnover) {
        return bookService.saveInImeiInfo(iemi_turnover);
    }

}
