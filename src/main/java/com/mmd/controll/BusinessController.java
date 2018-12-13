package com.mmd.controll;

import com.mmd.model.Merchant;
import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;
import com.mmd.service.BusinessService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 商家及其商品控制类
 */
@Controller
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @RequestMapping("/getMerchantList")
    public @ResponseBody ResultPage getMerchantList(Page page, Merchant merchant) {
        return businessService.getMerchantList(page, merchant);
    }

    //详细
    @RequestMapping("/toBusinessDetail")
    public ModelAndView toBusinessDetail(String id) {
        ModelAndView modelAndView = new ModelAndView();
        Merchant merchant = businessService.getBusinessDetail(id);
        modelAndView.addObject("merchant", merchant);
        modelAndView.setViewName("../content/business/businesslist.jsp");
        return modelAndView;
    }

    @RequestMapping("/delBusiness")
    public @ResponseBody
    Result delBusiness(String ids) {
        return businessService.delBusiness(ids);
    }
}
