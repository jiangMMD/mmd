package com.mmd.controll;

import com.mmd.model.User;
import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;
import com.mmd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserControll {
    @Autowired
   private UserService userService;

    @RequestMapping("/getUser")
    @ResponseBody
    public ResultPage<User> getUser(Page page, User user){
        return userService.getUser(page,user);

    }

    @RequestMapping("/delUser")
    public @ResponseBody
    Result delUser (String ids) {
        return userService.delUser(ids);
    }

    @RequestMapping("/toUserDetail")
    public ModelAndView toCustomDetail(String uid) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getUserDetail(uid);
        if(user == null) {
            modelAndView.setViewName("../content/common/error-403.html");
        }else{
            modelAndView.addObject("user", user);
            modelAndView.setViewName("../content/user/userdetail.jsp");
        }
        return modelAndView;
    }

    @RequestMapping("/saveUserInfo")
    public @ResponseBody
    Result saveUserInfo(User user){
        System.out.println(user);
        return userService.saveUserInfo(user);
    }
    @RequestMapping("/queryAddress")
    public @ResponseBody Result queryAddress(String uid){
        return userService.queryAddress(uid);
    }
    @RequestMapping("/queryAddressByUid")
    public @ResponseBody Result queryAddressByBid(String uid){
        return userService.queryAddressByUid(uid);
    }

    @RequestMapping("delAddress")
    public @ResponseBody Result delAddress(String id){
        return userService.delAddress(id);
    }

    @RequestMapping("/getUserByKey")
    public @ResponseBody
    Map<String, Object> getUserByKey(@RequestParam Map<String, Object> params) {
        String key = (String) params.get("key");
        Map<String, Object> result = new HashMap<>();
        List<Map<String, Object>> list = userService.getUserByKey(key);
        result.put("result", list);
        return result;
    }

    @RequestMapping("/getUserByPhone")
    public @ResponseBody Map<String ,Object> getUserByPhone(@RequestParam Map<String, Object> params){
        String key = (String) params.get("key");
        Map<String, Object> result = new HashMap<>();
        List<Map<String,Object>> list = userService.getUserByPhone(key);
        result.put("result",list);
        return result;
    }

    @RequestMapping("/getUserByName")
    public @ResponseBody Map<String ,Object> getUserByName(@RequestParam Map<String, Object> params){
        String key = (String) params.get("key");
        Map<String, Object> result = new HashMap<>();
        List<Map<String,Object>> list = userService.getUserByName(key);
        result.put("result",list);
        return result;
    }

    @RequestMapping("/getCollections")
    public @ResponseBody ResultPage getCollections(Page page,@RequestParam Map<String, String> params){
        return userService.getCollections(page,params);
    }

}
