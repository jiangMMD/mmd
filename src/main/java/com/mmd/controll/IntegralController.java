package com.mmd.controll;

import com.mmd.model.Integral;
import com.mmd.model.IntegralLog;
import com.mmd.model.Shopcat;
import com.mmd.pjo.Page;
import com.mmd.pjo.ResultPage;
import com.mmd.service.IntegralLogService;
import com.mmd.service.ShopcatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/integral")
public class IntegralController {
    @Autowired
    private IntegralLogService integralLogService;

    @Autowired
    private ShopcatService shopcatService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpSession session;


    @RequestMapping("/getIntegralList")
    public @ResponseBody
    ResultPage getIntegralList(Page page, IntegralLog integralLog) {
        return integralLogService.getIntegralLogList(page, integralLog);
    }

    @RequestMapping("/getShopcatList")
    public @ResponseBody
    ResultPage getShopcatList(Page page, Shopcat shopcat) {
        return shopcatService.getShopcatList(page, shopcat);

    }

    @RequestMapping("/shopcatdetail")
    public ModelAndView shopcatdetail(String catId) {
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> shopdetail = shopcatService.shopcatDetail(catId);
        System.out.println(shopdetail);
        modelAndView.addObject("shopdetail", shopdetail);
        modelAndView.setViewName("../content/user/shopcatdetail.jsp");
        return modelAndView;
    }

}
