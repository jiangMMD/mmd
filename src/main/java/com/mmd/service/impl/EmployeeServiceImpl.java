package com.mmd.service.impl;

import com.github.pagehelper.PageHelper;
import com.mmd.constant.SysConstants;
import com.mmd.dao.EmployeeDao;
import com.mmd.model.Employee;
import com.mmd.model.Role;
import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;
import com.mmd.plugin.QueryParamInterface;
import com.mmd.service.EmployeeService;
import com.mmd.utils.PublicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpSession session;

    @Override
    public Result login(Employee employee) {
        employee.setPassword(DigestUtils.md5DigestAsHex(employee.getPassword().getBytes()));
        Employee employeeDb = employeeDao.findUserWithNameAndPass(employee);
        if(employeeDb != null) {
            //加载用户权限信息
            if(!StringUtils.isEmpty(employeeDb.getRoleId())) {
                List<Role> role = employeeDao.getMenu(PublicUtil.toListByIds(employeeDb.getRoleId()));
                System.out.println(role);
                employeeDb.setRoles(role);
            }
            System.out.println(employeeDb);
            request.getSession().setAttribute("employee", employeeDb);
            return new Result();
        }else{
            return new Result(0, "用户名或密码错误！");
        }
    }


    @Override
    public Result updPass(Map<String, Object> param) {
        String password = (String) param.get("password");
        //校验密码是否正确
        Employee employee = (Employee) session.getAttribute("employee");
        if(Objects.equals(DigestUtils.md5DigestAsHex(password.getBytes()), employee.getPassword())) {
            String newpass = (String) param.get("newpassword");
            String confpass = (String) param.get("cfmpassword");
            if(newpass.length() < 4 || newpass.length() > 20 || !Objects.equals(newpass, confpass)) {
                return new Result(0, "参数异常，操作失败！");
            }
            String md5Pass = DigestUtils.md5DigestAsHex(newpass.getBytes());
            employeeDao.updPass(employee.getId(), md5Pass);
            //修改session中用户密码
            employee.setPassword(md5Pass);
            session.setAttribute("employee", employee);
            return new Result();
        }else{
            return new Result(0, "密码错误，操作失败！");
        }
    }

    @Override
    public void updateUserHeadIcon(Employee employee) {
        employeeDao.updateUserHeadIcon(employee.getId(), employee.getHeadicon());
    }

    /**
     * 获取所有用户信息
     * @param page
     *      分页信息
     */
    @Override
    public ResultPage getAllEmployee(Page page, Employee employee) {
        QueryParamInterface.setLocalPage(page);
        PageHelper.startPage(page);
        //处理查询参数问题
        List<Employee> list = employeeDao.getAllEmployee(employee);
        return new ResultPage<>(list);
    }

    @Override
    public Result updUserInfo(Employee employee) {
        employee.setUpduser(((Employee)session.getAttribute("employee")).getName());
        //校验登录名及其用户名是否重复
        Employee userByDb = employeeDao.getUserWithNoOrName(employee.getLoginNo(), employee.getName(), employee.getId());
        if(userByDb == null) {
            employeeDao.updUserInfo(employee);
        }else if(employee.getLoginNo().equalsIgnoreCase(userByDb.getLoginNo())) {
            return new Result(0, "该登录名已存在，请更换其他登录名");
        }else if(employee.getName().equalsIgnoreCase(userByDb.getName())) {
            return new Result(0, "该姓名已经存在，请尝试更换其他姓名");
        }
        return new Result();
    }

    @Override
    public void delUserInfo(String id) {
        employeeDao.delUserInfo(PublicUtil.toListByIds(id));
    }

    @Override
    public Result addUserInfo(Employee employee) {
        //设置默认密码
        employee.setPassword(DigestUtils.md5DigestAsHex(SysConstants.USER_PASSWORD.getBytes()));
        //设置默认头型
        employee.setHeadicon(SysConstants.USER_DEFAULT_HEADICON);
        Employee currLoginUser = (Employee) session.getAttribute("employee");
        employee.setCrtuser(currLoginUser.getName());
        employee.setUpduser(currLoginUser.getName());
        Employee employeeDb = employeeDao.getUserWithNoOrName(employee.getLoginNo(), employee.getName(), null);
        if(employeeDb == null) {
            employeeDao.addUserInfo(employee);
        }else if(employee.getLoginNo().equalsIgnoreCase(employeeDb.getLoginNo())) {
            return new Result(0, "该登录名已存在，请更换其他登录名");
        }else if(employee.getName().equalsIgnoreCase(employeeDb.getName())) {
            return new Result(0, "该姓名已经存在，请尝试更换其他姓名");
        }
        return new Result();
    }

    @Override
    public List<Role> getMenu(String role_id) {
        return employeeDao.getMenu(PublicUtil.toListByIds(role_id));
    }

    @Override
    public Result getMenuWithRuleIds(String role_ids) {
        return new Result(1, "查询成功！", employeeDao.getMenuWithRuleIds(PublicUtil.toSetByIds(role_ids)));
    }

    @Override
    public Result getMenuByRId(String role_ids) {
        return new Result(1, "查询成功！", employeeDao.getMenuByRId(PublicUtil.toListByIds(role_ids)));
    }

    @Override
    public Result updRoleName(Map<String, Object> params) {
        int count = employeeDao.queryRoleName((String) params.get("newrname"));
        if(count > 0) {
            return new Result(0, "该权限名称已存在，请更换其他名称！");
        }
        employeeDao.updRoleName(params);
        return new Result();
    }

    @Override
    public Result getRoleByUser(String uid) {
        return new Result(1, "查询成功！", employeeDao.getRoleByUser(uid));
    }

    @Override
    public Result saveUserRole(Employee employee) {
        employee.setUpduser(((Employee)session.getAttribute("employee")).getName());
        employeeDao.saveUserRole(employee);
        return new Result();
    }

    @Override
    public Result updUserIcon(String imgSrc) {
        Employee employee = (Employee) session.getAttribute("employee");
        employee.setHeadicon(imgSrc);
        employeeDao.updUserIcon(employee);
        return new Result();
    }

    @Override
    public Result updUserName(String username) {
        if(StringUtils.isEmpty(username)) {
            return new Result(0, "姓名不能为空");
        }
        Employee employee = (Employee) session.getAttribute("employee");
        employee.setName(username);
        int count = employeeDao.getCountWithUserName(employee);
        if(count > 0) {
            return new Result(0, "姓名已存在，请尝试更换其他,或添加其他标识");
        }
        employeeDao.updUserName(employee);
        session.setAttribute("employee", employee);
        return new Result(1, "操作成功！", employee);
    }

    @Override
    public Result updUserAge(Integer age) {
        if(StringUtils.isEmpty(age)) {
            return new Result(0, "年龄不能为空");
        }
        Employee employee = (Employee) session.getAttribute("employee");
        employee.setAge(age);
        employeeDao.updUserAge(employee);
        session.setAttribute("employee", employee);
        return new Result(1, "操作成功！", employee);
    }

    @Override
    public Result updUserBirthday(String birthday) {
        Employee employee = (Employee) session.getAttribute("employee");
        employee.setBirthday(birthday);
        employeeDao.updUserBirthday(employee);
        session.setAttribute("employee", employee);
        return new Result(1, "操作成功！", employee);
    }

    @Override
    public Result updUserTelephone(String telephone) {
        Employee employee = (Employee) session.getAttribute("employee");
        employee.setCellphone(telephone);
        employeeDao.updUserTelephone(employee);
        session.setAttribute("user", employee);
        return new Result(1, "操作成功！", employee);
    }

    @Override
    public Result updUserCellphone(String cellphone) {
        Employee employee = (Employee) session.getAttribute("employee");
        employee.setCellphone(cellphone);
        employeeDao.updUserCellphone(employee);
        session.setAttribute("employee", employee);
        return new Result(1, "操作成功！", employee);
    }

    @Override
    public Result updUserWeixin(String weixin) {
        Employee employee = (Employee) session.getAttribute("employee");
        employee.setWeixin(weixin);
        employeeDao.updUserWeixin(employee);
        session.setAttribute("employee", employee);
        return new Result(1, "操作成功！", employee);
    }

    @Override
    public Result updUserQq(String qq) {
        Employee employee = (Employee) session.getAttribute("employee");
        employee.setQq(qq);
        employeeDao.updUserQq(employee);
        session.setAttribute("user", employee);
        return new Result(1, "操作成功！", employee);
    }

    @Override
    public Result getMyEvent() {
        Employee employee = (Employee) session.getAttribute("employee");
        return new Result(1, "查询成功", employeeDao.getMyEvent(employee.getId()));
    }

    @Override
    public Result addEvent(Map<String, Object> params) {
        Employee employee = (Employee) session.getAttribute("employee");
        params.put("uid", employee.getId());
        params.put("eid", "");
        employeeDao.addEvent(params);
        return new Result(1, "操作成功", params);
    }

    @Override
    public Result editEvent(Map<String, Object> params) {
        employeeDao.editEvent(params);
        return new Result();
    }

    @Override
    public Result delEvent(String eid) {
        employeeDao.delEvent(eid);
        return new Result();
    }

    @Override
    public Employee getUserDetail(String id) {
        return employeeDao.getUserDetail(id);
    }

    @Override
    public Result addUpdEmployee(Employee employee) {
        int count = employeeDao.getCountWithLoginNo(employee);
        System.out.println(count);
        if(count > 0) {
            return new Result(0, "该登录名已被使用，请尝试更换其他");
        }
        Employee loginEmployee = (Employee) session.getAttribute("employee");
        if(employee.getId() != null) {
            employee.setUpduser(loginEmployee.getLoginNo());
            employeeDao.updUserInfo(employee);
        }else{
            employee.setCrtuser(loginEmployee.getLoginNo());
            employee.setPassword(DigestUtils.md5DigestAsHex(SysConstants.USER_PASSWORD.getBytes()));
            employeeDao.addUserInfo(employee);
        }
        return new Result();
    }

    @Override
    public Result getMessage() {
        Employee user = (Employee) session.getAttribute("employee");
        int count = employeeDao.getMsgCount(user.getId());
        List<Map<String, Object>> list = employeeDao.getMessage(user.getId());
        Map<String, Object> resData = new HashMap<>();
        resData.put("count", count);
        resData.put("list", list);
        return new Result(1, "查询成功", resData);
    }
}
