package com.mmd.controll;

import com.mmd.model.ProdSkupropname;
import com.mmd.model.ProdSkupropval;
import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;
import com.mmd.service.PropvalService;
import com.mmd.service.PropnameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Objects;

/**
 * 获取所有的基础信息
 */
@RestController
@RequestMapping("product")
public class ProductControll {
    @Autowired
    private PropnameService propnameService;
    @Autowired
    private PropvalService propvalService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpSession session;


    @RequestMapping("/getAllProp")
    public @ResponseBody
    ResultPage getAllProp(Page page, ProdSkupropname prodSkupropname) {
        return propnameService.getAllProp(page, prodSkupropname);

    }

    @RequestMapping("/CRUD_PropInfo")
    public @ResponseBody
    Result crudPropInfo(String oper, String id, ProdSkupropname prodSkupropname) {
        if(Objects.equals(oper, "edit")) {
            if(org.springframework.util.StringUtils.isEmpty(prodSkupropname.getPropName()) || org.springframework.util.StringUtils.isEmpty(prodSkupropname.getPropId())) {
                return new Result(0, "参数异常，属性名不能为空");
            }
            //修改操作
            return propnameService.updPropnameInfo(prodSkupropname);
        }else if(Objects.equals(oper, "del")) {
            //删除操作
            propnameService.delPropnameInfo(id);
        }else if(Objects.equals(oper, "add")){
            if(org.springframework.util.StringUtils.isEmpty(prodSkupropname.getPropName()) || org.springframework.util.StringUtils.isEmpty(prodSkupropname.getPropId())) {
                return new Result(0, "参数异常，属性名不能为空");
            }
            return propnameService.addPropnameInfo(prodSkupropname);
        }else{
            return new Result(0, "参数异常，操作失败！");
        }
        return new Result();
    }

    @RequestMapping("toPropValDetail")
    public ModelAndView toPropValDetail(String id) {
        ModelAndView modelAndView = new ModelAndView();
//        Map<String, Object> shopdetail = shopcatService.shopcatDetail(catId);
        Map<String, Object> prodSkupropval = propvalService.getPropValDetail(id);
//        ProdSkupropval prodSkupropval = propvalService.getPropValDetail(id);
        modelAndView.addObject("prodSkupropval", prodSkupropval);
        modelAndView.setViewName("../content/employee/employeedetail.jsp");
        return modelAndView;
    }
}
