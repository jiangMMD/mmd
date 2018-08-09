package com.mmt.controll;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmt.model.Book;
import com.mmt.model.Role;
import com.mmt.model.User;
import com.mmt.pjo.Page;
import com.mmt.pjo.Result;
import com.mmt.pjo.ResultPage;
import com.mmt.service.UserService;
import com.mmt.utils.HttpClientUtil;
import com.mmt.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/user")
public class UserControll {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpSession session;

    @Autowired
    private UserService userService;


    @RequestMapping("/login")
    public @ResponseBody Result login(User user) {
        System.out.println(user);
        return userService.login(user);
    }


    @RequestMapping("/getUserInfo")
    public @ResponseBody Result getUserInfo() {
        return new Result(1, "查询成功！", session.getAttribute("user"));
    }

    @RequestMapping("/checkUserPass")
    public @ResponseBody Boolean checkUserPass(String password) {
        User user = (User) request.getSession().getAttribute("user");
        if(DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
            return true;
        }
        return false;
    }

    @RequestMapping("/updPass")
    public @ResponseBody Result updPass(@RequestParam Map<String, Object> param, HttpServletResponse response) {
        return userService.updPass(param);
    }


    @RequestMapping("/getAllUser")
    public @ResponseBody ResultPage getAllUser(Page page, User user) {
        return userService.getAllUser(page, user);
    }

    @RequestMapping("/CRUD_UserInfo")
    public @ResponseBody Result crudUserInfo(String oper, String id, User user) {
        if(Objects.equals(oper, "edit")) {
            if(StringUtils.isEmpty(user.getUser_no()) || StringUtils.isEmpty(user.getUsername())) {
                return new Result(0, "参数异常，登录名及其用户名不能为空");
            }
            //修改操作
            return userService.updUserInfo(user);
        }else if(Objects.equals(oper, "del")) {
            //删除操作
            userService.delUserInfo(id);
        }else if(Objects.equals(oper, "add")){
            if(StringUtils.isEmpty(user.getUser_no()) || StringUtils.isEmpty(user.getUsername())) {
                return new Result(0, "参数异常，登录名及其用户名不能为空");
            }
            return userService.addUserInfo(user);
        }else{
            return new Result(0, "参数异常，操作失败！");
        }
        return new Result();
    }

    /**
     * 加载用户菜单信息
     * @return
     */
    @RequestMapping("/getMenu")
    public @ResponseBody Result getMenu() {
        User user = (User) session.getAttribute("user");
        if(user.getRoles() != null && user.getRoles().size() > 0) {
            return new Result(1, "查询成功！", user.getRoles());
        }
        List<Role> list = userService.getMenu(user.getRole_id());
        return new Result(1, "查询成功！", list);
    }

    @RequestMapping("/getMenuWithRuleIds")
    public @ResponseBody Result getMenuWithRuleIds(String role_ids) {
        return userService.getMenuWithRuleIds(role_ids);
    }

    @RequestMapping("/getMenuByRId")
    public @ResponseBody Result getMenuByRId(String role_ids) {
        return userService.getMenuByRId(role_ids);
    }

    @RequestMapping("/updRoleName")
    public @ResponseBody Result updRoleName(@RequestParam Map<String, Object> params) {
        return userService.updRoleName(params);
    }


    @RequestMapping("/getRoleByUser")
    public @ResponseBody Result getRoleByUser(String uid) {
        return userService.getRoleByUser(uid);
    }

    @RequestMapping("/saveUserRole")
    public @ResponseBody Result saveUserRole(User user) {
        return userService.saveUserRole(user);
    }

    @RequestMapping("/updUserIcon")
    public @ResponseBody Result updUserIcon(String imgSrc) {
        return userService.updUserIcon(imgSrc);
    }


    /**修改用户的相关信息**/
    @RequestMapping("/updUserName")
    public @ResponseBody Result updUserName(String username) {
        return userService.updUserName(username);
    }

    @RequestMapping("/updUserAge")
    public @ResponseBody Result updUserAge(Integer age) {
        return userService.updUserAge(age);
    }

    @RequestMapping("/updUserBirthday")
    public @ResponseBody Result updUserBirthday(String birthday) {
        return userService.updUserBirthday(birthday);
    }

    @RequestMapping("/updUserTelephone")
    public @ResponseBody Result updUserTelephone(String telephone) {
        return userService.updUserTelephone(telephone);
    }

    @RequestMapping("/updUserCellphone")
    public @ResponseBody Result updUserCellphone(String cellphone) {
        return userService.updUserCellphone(cellphone);
    }

    @RequestMapping("/updUserWeixin")
    public @ResponseBody  Result updUserWeixin(String weixin) {
        return userService.updUserWeixin(weixin);
    }

    @RequestMapping("/updUserQq")
    public @ResponseBody Result updUserQq(String qq) {
        return userService.updUserQq(qq);
    }


    @RequestMapping("addEvent")
    public @ResponseBody Result addEvent(@RequestParam Map<String, Object> params) {
        System.out.println(params);
        return userService.addEvent(params);
    }

    @RequestMapping("editEvent")
    public @ResponseBody Result editEvent(@RequestParam Map<String, Object> params) {
        return userService.editEvent(params);
    }

    @RequestMapping("getMyEvent")
    public @ResponseBody Result getMyEvent() {
        return userService.getMyEvent();
    }

    @RequestMapping("delEvent")
    public @ResponseBody Result delEvent(String eid) {
        return userService.delEvent(eid);
    }

    @RequestMapping("toUserDetail")
    public ModelAndView toUserDetail(String id) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getUserDetail(id);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("../content/user/userdetail.jsp");
        return modelAndView;
    }

    @RequestMapping("addOrUpdUser")
    public @ResponseBody Result addOrUpdUser(User user) {
        return userService.addOrUpdUser(user);
    }
}
