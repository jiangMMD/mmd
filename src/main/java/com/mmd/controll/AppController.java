package com.mmd.controll;

import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;
import com.mmd.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * APP设置控制类
 */
@Controller
@RequestMapping("/app")
public class AppController {

    @Autowired
    private AppService appService;

    @RequestMapping("/getClassify")
    public @ResponseBody ResultPage getClassify(Page page, Map<String, String> params) {
        return appService.getClassify(page, params);
    }

    @RequestMapping("/toClassifyDetail")
    public ModelAndView toClassifyDetail(String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("../content/app/classifydetail.jsp");
        Map<String, Object> map = appService.getClassifyById(id);
        modelAndView.addObject("classify", map);
        return modelAndView;
    }

    @RequestMapping("/addOrUpdClassify")
    public @ResponseBody Result addOrUpdClassify(Map<String, Object> data) {
        return appService.addOrUpdClassify(data);
    }

}
