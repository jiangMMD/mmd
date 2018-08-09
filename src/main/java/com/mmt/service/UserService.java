package com.mmt.service;

import com.mmt.model.Role;
import com.mmt.model.User;
import com.mmt.pjo.Page;
import com.mmt.pjo.Result;
import com.mmt.pjo.ResultPage;

import java.util.List;
import java.util.Map;

public interface UserService {
    Result login(User user);

    Result updPass(Map<String, Object> param);

    void updateUserHeadIcon(User user);

    ResultPage getAllUser(Page page, User user);

    Result updUserInfo(User user);

    void delUserInfo(String id);

    Result addUserInfo(User user);

    List<Role> getMenu(String role_id);

    Result getMenuWithRuleIds(String role_ids);

    Result getMenuByRId(String role_ids);

    Result updRoleName(Map<String, Object> params);

    Result getRoleByUser(String uid);

    Result saveUserRole(User user);

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

    User getUserDetail(String id);

    Result addOrUpdUser(User user);
}
