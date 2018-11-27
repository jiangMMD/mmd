package com.mmd.service;


import com.mmd.model.Employee;
import com.mmd.model.Role;
import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Result login(Employee employee);

    Result updPass(Map<String, Object> param);

    void updateUserHeadIcon(Employee employee);

    ResultPage getAllEmployee(Page page, Employee employee);

    Result updUserInfo(Employee employee);

    void delUserInfo(String id);

    Result addUserInfo(Employee employee);

    List<Role> getMenu(String role_id);

    Result getMenuWithRuleIds(String role_ids);

    Result getMenuByRId(String role_ids);

    Result updRoleName(Map<String, Object> params);

    Result getRoleByUser(String uid);

    Result saveUserRole(Employee employee);

    Result updUserIcon(String imgSrc);

    Result updUserName(String username);

    Result updUserAge(Integer age);

    Result updUserBirthday(String birthday);

    Result updUserTelephone(String telephone);

    Result updUserCellphone(String cellphone);

    Result updUserWeixin(String weixin);

    Result updUserQq(String qq);

    Result getMyEvent();

    Result addEvent(Map<String, Object> params);

    Result editEvent(Map<String, Object> params);

    Result delEvent(String eid);

    Employee getUserDetail(String id);

    Result addUpdEmployee(Employee employee);

    Result getMessage();
}
