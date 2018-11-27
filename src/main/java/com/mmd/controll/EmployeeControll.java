package com.mmd.controll;

import com.mmd.model.Employee;
import com.mmd.model.Role;
import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;
import com.mmd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/employee")
public class EmployeeControll {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpSession session;

    @Autowired
    private EmployeeService employeeService;


    @RequestMapping("/login")
    public @ResponseBody
    Result login(Employee employee) {
        return employeeService.login(employee);
    }


    @RequestMapping("/getUserInfo")
    public @ResponseBody
    Result getUserInfo() {
        return new Result(1, "查询成功！", session.getAttribute("employee"));
    }

    @RequestMapping("/checkUserPass")
    public @ResponseBody Boolean checkUserPass(String password) {
        Employee employee = (Employee) request.getSession().getAttribute("employee");
        if(DigestUtils.md5DigestAsHex(password.getBytes()).equals(employee.getPassword())) {
            return true;
        }
        return false;
    }

    @RequestMapping("/updPass")
    public @ResponseBody
    Result updPass(@RequestParam Map<String, Object> param, HttpServletResponse response) {
        return employeeService.updPass(param);
    }

    @RequestMapping("/getAllEmployee")
    public @ResponseBody
    ResultPage getAllUser(Page page, Employee employee) {
        return employeeService.getAllEmployee(page, employee);

    }

    @RequestMapping("/CRUD_UserInfo")
    public @ResponseBody
    Result crudUserInfo(String oper, String id, Employee employee) {
        if(Objects.equals(oper, "edit")) {
            if(StringUtils.isEmpty(employee.getLoginNo()) || StringUtils.isEmpty(employee.getName())) {
                return new Result(0, "参数异常，登录名及其用户名不能为空");
            }
            //修改操作
            return employeeService.updUserInfo(employee);
        }else if(Objects.equals(oper, "del")) {
            //删除操作
            employeeService.delUserInfo(id);
        }else if(Objects.equals(oper, "add")){
            if(StringUtils.isEmpty(employee.getLoginNo()) || StringUtils.isEmpty(employee.getName())) {
                return new Result(0, "参数异常，登录名及其用户名不能为空");
            }
            return employeeService.addUserInfo(employee);
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
    public @ResponseBody
    Result getMenu() {
        Employee employee = (Employee) session.getAttribute("employee");
        if(employee.getRoles() != null && employee.getRoles().size() > 0) {
            return new Result(1, "查询成功！", employee.getRoles());
        }
        List<Role> list = employeeService.getMenu(employee.getRoleId());
        return new Result(1, "查询成功！", list);
    }

    @RequestMapping("/getMenuWithRuleIds")
    public @ResponseBody
    Result getMenuWithRuleIds(String role_ids) {
        return employeeService.getMenuWithRuleIds(role_ids);
    }

    @RequestMapping("/getMenuByRId")
    public @ResponseBody
    Result getMenuByRId(String role_ids) {
        return employeeService.getMenuByRId(role_ids);
    }

    @RequestMapping("/updRoleName")
    public @ResponseBody
    Result updRoleName(@RequestParam Map<String, Object> params) {
        return employeeService.updRoleName(params);
    }


    @RequestMapping("/getRoleByUser")
    public @ResponseBody
    Result getRoleByUser(String uid) {
        return employeeService.getRoleByUser(uid);
    }

    @RequestMapping("/saveUserRole")
    public @ResponseBody
    Result saveUserRole(Employee employee) {
        return employeeService.saveUserRole(employee);
    }

    @RequestMapping("/updUserIcon")
    public @ResponseBody
    Result updUserIcon(String imgSrc) {
        return employeeService.updUserIcon(imgSrc);
    }

    /**修改用户的相关信息**/
    @RequestMapping("/updUserName")
    public @ResponseBody
    Result updUserName(String username) {
        return employeeService.updUserName(username);
    }

    @RequestMapping("/updUserAge")
    public @ResponseBody
    Result updUserAge(Integer age) {
        return employeeService.updUserAge(age);
    }

    @RequestMapping("/updUserBirthday")
    public @ResponseBody
    Result updUserBirthday(String birthday) {
        return employeeService.updUserBirthday(birthday);
    }

    @RequestMapping("/updUserTelephone")
    public @ResponseBody
    Result updUserTelephone(String telephone) {
        return employeeService.updUserTelephone(telephone);
    }

    @RequestMapping("/updUserCellphone")
    public @ResponseBody
    Result updUserCellphone(String cellphone) {
        return employeeService.updUserCellphone(cellphone);
    }

    @RequestMapping("/updUserWeixin")
    public @ResponseBody
    Result updUserWeixin(String weixin) {
        return employeeService.updUserWeixin(weixin);
    }

    @RequestMapping("/updUserQq")
    public @ResponseBody
    Result updUserQq(String qq) {
        return employeeService.updUserQq(qq);
    }


    @RequestMapping("addEvent")
    public @ResponseBody
    Result addEvent(@RequestParam Map<String, Object> params) {
        System.out.println(params);
        return employeeService.addEvent(params);
    }

    @RequestMapping("editEvent")
    public @ResponseBody
    Result editEvent(@RequestParam Map<String, Object> params) {
        return employeeService.editEvent(params);
    }

    @RequestMapping("getMyEvent")
    public @ResponseBody
    Result getMyEvent() {
        return employeeService.getMyEvent();
    }

    @RequestMapping("delEvent")
    public @ResponseBody
    Result delEvent(String eid) {
        return employeeService.delEvent(eid);
    }

    @RequestMapping("toUserDetail")
    public ModelAndView toUserDetail(String id) {
        ModelAndView modelAndView = new ModelAndView();
        Employee employee = employeeService.getUserDetail(id);
        modelAndView.addObject("employee", employee);
        modelAndView.setViewName("../content/employee/employeedetail.jsp");
        return modelAndView;
    }

    @RequestMapping("addUpdEmployee")
    public @ResponseBody
    Result addUpdEmployee(Employee employee) {
        return employeeService.addUpdEmployee(employee);
    }


    @RequestMapping("getMessage")
    public @ResponseBody
    Result getMessage() {
        return employeeService.getMessage();
    }
}
