package com.mmt.dao;

import com.mmt.model.Menu;
import com.mmt.model.Role;
import com.mmt.model.User;
import com.mmt.pjo.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserDao {

    User findUserWithNameAndPass(User user);

    List<Role> getRoleWithIds(@Param("role_ids") List<String> role_ids);

    void updPass(@Param("uid") long uid, @Param("newpass") String newpass);

    void updateUserHeadIcon(@Param("uid") long uid, @Param("headicon") String headicon);

    List<User> getAllUser(User user);

    void delUserInfo(@Param("ids") List<String> ids);

    void updUserInfo(User user);

    void addUserInfo(User user);

    User getUserWithNoOrName(@Param("user_no") String user_no, @Param("username") String username, @Param("uid") Long uid);

    List<Role> getMenu(@Param("ids") List<String> ids);

    List<Menu> getMenuWithRuleIds(@Param("role_ids") Set<String> role_ids);

    List<Menu> getMenuByRId(@Param("role_ids") List<String> role_ids);

    int queryRoleName(@Param("rname") String rname);

    void updRoleName(@Param("params") Map<String, Object> params);

    void addRole(Role role);

    User getRoleByUser(@Param("uid") String uid);

    void saveUserRole(User user);

    void updUserIcon(User user);

    int getCountWithUserName(User user);

    void updUserName(User user);

    void updUserAge(User user);

    void updUserBirthday(User user);

    void updUserTelephone(User user);

    void updUserCellphone(User user);

    void updUserWeixin(User user);

    void updUserQq(User user);

    List<Map<String, Object>> getMyEvent(@Param("uid") Long uid);

    void addEvent(@Param("params") Map<String, Object> params);

    void editEvent(@Param("params") Map<String, Object> params);

    void delEvent(@Param("eid") String eid);

    User getUserDetail(@Param("id") String id);

    int getCountWithLoginNo(User user);

    Map<String, Object> getUserByMenuId(@Param("menuId") int menuId);

    void addUserMessage(@Param("uids") List<String> uids, @Param("message") String message);
}
