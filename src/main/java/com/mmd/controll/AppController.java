package com.mmd.controll;

import com.mmd.model.Message;
import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;
import com.mmd.service.AppService;
import com.mmd.service.MessageService;
import com.mmd.utils.PropertyLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

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

    /**
     * 添加修改商品信息
     * @param picUrlFile
     * @param message
     * @return
     */
    @RequestMapping("/addMessage")
    public @ResponseBody
    Result saveUserInfo(MultipartFile picUrlFile, Message message) throws IOException {
        if(picUrlFile !=null && !picUrlFile.isEmpty()) {
            String fileName = dealFile(picUrlFile, PropertyLoad.getProperty("message_filedir"));
            String url = PropertyLoad.getProperty("message_url") + fileName;
            message.setPicUrl(url);
        }
        return messageService.addMessage(message);
    }

    private String dealFile(MultipartFile file, String dir) throws IOException {
        if (file == null) {
            return null;
        }
        String file_sourcename = file.getOriginalFilename();
        String ref = file_sourcename.substring(file_sourcename.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString().replaceAll("_", "").substring(0, 8);
        String filename = uuid + ref;
        File dirFile = new File(dir + File.separator +filename);
        if (!dirFile.getParentFile().exists()) {
            dirFile.getParentFile().mkdirs();
        }
        File bookFile = new File(dir + File.separator + filename);
        file.transferTo(bookFile);
        return filename;
    }

}
