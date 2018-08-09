package com.mmt.controll;

import com.mmt.model.Iemi_turnover;
import com.mmt.model.Role;
import com.mmt.pjo.Result;
import com.mmt.service.BaseService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 获取所有的基础信息
 */
@RestController
@RequestMapping("base")
public class BaseControll {

    @Autowired
    private BaseService baseService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpSession session;

    @RequestMapping("getAllDepartment")
    public Result getAllDepartment() {
        return baseService.getAllDepartment();
    }

    /**
     * 加载所有菜单
     */
    @RequestMapping("getAllMenu")
    public Result getAllMenu() {
        return baseService.getAllMenu();
    }

    /**
     * 根据关键字检索员工信息
     */
    @RequestMapping("getUserByKey")
    public Result getUserByKey(String key) {
        return baseService.getUserByKey(key);
    }

    /**
     * 加载所有权限信息
     */
    @RequestMapping("/getAllRoleInfo")
    public Result getAllRoleInfo() {
        return baseService.getAllRoleInfo();
    }

    /**
     * 更新权限菜单
     * @return
     */
    @RequestMapping("/updRoleMenu")
    public Result updRoleMenu(Role role) {
        return baseService.updRoleMenu(role);
    }

    @RequestMapping("/addRole")
    public Result addRole(Role role) {
        if(StringUtils.isEmpty(role.getRname())) {
            return new Result(0, "权限名称不能为空");
        }
        return baseService.addRole(role);
    }

    @RequestMapping("/delRole")
    public Result delRole(String rid) {
        return baseService.delRole(rid);
    }


    @RequestMapping("/getAllCity")
    public Result getAllCity() {
        return baseService.getAllCity();
    }

    @RequestMapping("/getAllAgency")
    public Result getAllAgency() {
        return baseService.getAllAgency();
    }

    @RequestMapping("/getAllPost")
    public Result getAllPost() {
        return baseService.getAllPost();
    }

    @RequestMapping("/getAllImeiWithHas")
    public Result getAllImeiWithHas(String id) {
        return baseService.getAllImeiWithHas(id);
    }

    @RequestMapping("/toImeiOutdetail")
    public ModelAndView toImeiOutdetail(String id) {
        ModelAndView modelAndView = new ModelAndView();
        Iemi_turnover iemi_turnover = baseService.toImeiOutdetail(id);
        modelAndView.addObject("iemi_turnover", iemi_turnover);
        modelAndView.setViewName("../content/base/imeioutdetail.jsp");
        return modelAndView;
    }

    @RequestMapping("/toImeiIndetail")
    public ModelAndView toImeiIndetail(String id) {
        ModelAndView modelAndView = new ModelAndView();
        Iemi_turnover iemi_turnover = baseService.toImeiIndetail(id);
        modelAndView.addObject("iemi_turnover", iemi_turnover);
        modelAndView.setViewName("../content/base/imeiindetail.jsp");
        return modelAndView;
    }
}
