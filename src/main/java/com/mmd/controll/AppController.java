package com.mmd.controll;

import com.mmd.model.Message;
import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;
import com.mmd.service.AppService;
import com.mmd.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @Autowired
    private MessageService messageService;

    @RequestMapping("/getClassify")
    public @ResponseBody ResultPage getClassify(Page page,@RequestParam Map<String, String> params) {
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
    public @ResponseBody Result addOrUpdClassify(@RequestParam Map<String, Object> data) {
        return appService.addOrUpdClassify(data);
    }

    /**
     * 删除分类信息
     * @return
     */
    @RequestMapping("/delClassify")
    public @ResponseBody Result delClassify(String ids) {
        return appService.delClassify(ids);
    }
    /**
     * 删除消息信息
     * @return
     */
    @RequestMapping("/delMessage")
    public @ResponseBody Result delMessage(String ids) {
        return messageService.delMessage(ids);
    }


    /*獲取所有消息*/
    @RequestMapping("/getAllMessage")
    public @ResponseBody ResultPage getAllMessge(Page page, Message message) {
        return  messageService.getAllMessage(page, message);
    }
    @RequestMapping("/addMessage")
    public @ResponseBody
    Result saveUserInfo(Message message){
        System.out.println(message);
        return messageService.addMessage(message);
    }
}
