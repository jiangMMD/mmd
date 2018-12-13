package com.mmd.controll;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mmd.model.Integral;
import com.mmd.model.Message;
import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;
import com.mmd.service.AppService;
import com.mmd.service.MessageService;
import com.mmd.utils.PropertyLoad;
import com.mmd.utils.PublicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import java.io.File;
import java.io.IOException;
import java.util.*;

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


    @RequestMapping("/getClassifyList")
    public @ResponseBody Result getClassifyList() {
        return appService.getClassifyList();
    }

    @RequestMapping("/saveIntegral")
    public @ResponseBody Result saveIntegral(@RequestParam Map<String, Object> params){
        return appService.savaIntegral(params);
    }

    @RequestMapping("/loadJifen")
    public  @ResponseBody Result loadJifen() {
        return appService.loadJifen();
    }

    @RequestMapping("/loadExchange")
    public  @ResponseBody Result loadExchange() {
        return appService.loadExchange();
    }

    @RequestMapping("/saveClassifyInfo")
    public @ResponseBody Result saveClassifyInfo(@RequestParam Map<String, Object> params){
        System.out.println(params);
        List<Map<String, Object>> list = JSONObject.parseObject((String) params.get("data"), ArrayList.class);
        return appService.saveClassifyInfo(list);
    }

    @RequestMapping("getHotwordList")
    public @ResponseBody Result getHotwordList(){
        return appService.getHotwordList();
    }

    @RequestMapping("getHistoryList")
    public @ResponseBody Result getHistoryList(){
        return appService.getHistoryList();
    }

    @RequestMapping("saveHotWord")
    public @ResponseBody Result saveHotWord(@RequestParam Map<String, Object> params) {
        List<String > list = JSONObject.parseObject((String) params.get("data"), ArrayList.class);
        return appService.saveHotwordInfo(list);
    }

    @RequestMapping("/saveRateInfo")
    public @ResponseBody Result saveRateInfo(@RequestParam Map<String, Object> params){
        return appService.saveRateInfo(params);
    }


    @RequestMapping("/getCarousal")
    public @ResponseBody Result getCarousal() {
        return appService.getCarousal();
    }

    //通过关键字检索产品
    @RequestMapping("/getProdByKey")
    public @ResponseBody Result getProdByKey(String key) {
        return appService.getProdByKey(key);
    }

    //保存轮播图
    @RequestMapping("/saveCarousel")
    public @ResponseBody Result saveCarousel(MultipartFile carousalFile0, MultipartFile carousalFile1, MultipartFile carousalFile2,
                                             MultipartFile carousalFile3, MultipartFile carousalFile4, String prod_ids) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        String[]  ids = prod_ids.split(",");
        for (int i=0; i< ids.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("pid", ids[i]);
            map.put("orderby", i);
            list.add(map);
        }
        if(carousalFile0 != null && !carousalFile0.isEmpty()) {
            String filename = dealFile(carousalFile0, PropertyLoad.getProperty("homecarousel.savepath"));
            String url = PropertyLoad.getProperty("homecarousel.url") + filename;
            list.get(0).put("imgurl", url);
        }
        if(carousalFile1 != null && !carousalFile1.isEmpty()) {
            String filename = dealFile(carousalFile1, PropertyLoad.getProperty("homecarousel.savepath"));
            String url = PropertyLoad.getProperty("homecarousel.url") + filename;
            list.get(1).put("imgurl", url);
        }
        if(carousalFile2 != null && !carousalFile2.isEmpty()) {
            String filename = dealFile(carousalFile2, PropertyLoad.getProperty("homecarousel.savepath"));
            String url = PropertyLoad.getProperty("homecarousel.url") + filename;
            list.get(2).put("imgurl", url);
        }
        if(carousalFile3 != null && !carousalFile3.isEmpty()) {
            String filename = dealFile(carousalFile3, PropertyLoad.getProperty("homecarousel.savepath"));
            String url = PropertyLoad.getProperty("homecarousel.url") + filename;
            list.get(3).put("imgurl", url);
        }
        if(carousalFile4 != null && !carousalFile4.isEmpty()) {
            String filename = dealFile(carousalFile4, PropertyLoad.getProperty("homecarousel.savepath"));
            String url = PropertyLoad.getProperty("homecarousel.url") + filename;
            list.get(4).put("imgurl", url);
        }

        return appService.saveCarousel(list);
    }


    /**
     * 处理文件，
     */
    private String dealFile(MultipartFile file, String dir) throws IOException {
        if (file == null) {
            return null;
        }
        String file_sourcename = file.getOriginalFilename();
        String ref = file_sourcename.substring(file_sourcename.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString().replaceAll("_", "").substring(0, 8);
        String filename = uuid + ref;
        File dirFile = new File(dir);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        File bookFile = new File(dir + File.separator + filename);
        file.transferTo(bookFile);
        return filename;
    }


}
