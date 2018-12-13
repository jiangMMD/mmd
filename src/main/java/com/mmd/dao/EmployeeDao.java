package com.mmd.dao;

import com.mmd.model.Employee;
import com.mmd.model.Menu;
import com.mmd.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface EmployeeDao {

    Employee findUserWithNameAndPass(Employee employee);

    List<Role> getRoleWithIds(@Param("role_ids") List<String> role_ids);

    void updPass(@Param("uid") long uid, @Param("newpass") String newpass);

    void updateUserHeadIcon(@Param("uid") long uid, @Param("headicon") String headicon);

    List<Employee> getAllEmployee(Employee employee);

    void delUserInfo(@Param("ids") List<String> ids);

    void updUserInfo(Employee employee);

    void addUserInfo(Employee employee);

    Employee getUserWithNoOrName(@Param("user_no") String user_no, @Param("username") String username, @Param("uid") Long uid);

    List<Role> getMenu(@Param("ids") List<String> ids);

    List<Menu> getMenuWithRuleIds(@Param("role_ids") Set<String> role_ids);

    List<Menu> getMenuByRId(@Param("role_ids") List<String> role_ids);

    int queryRoleName(@Param("rname") String rname);

    void updRoleName(@Param("params") Map<String, Object> params);

    void addRole(Role role);

    Employee getRoleByUser(@Param("uid") String uid);

    void saveUserRole(Employee employee);

    void updUserIcon(Employee employee);

    int getCountWithUserName(Employee employee);

    void updUserName(Employee employee);

    void updUserAge(Employee employee);

    void updUserBirthday(Employee employee);

    void updUserTelephone(Employee employee);

    void updUserCellphone(Employee employee);

    void updUserWeixin(Employee employee);

    void updUserQq(Employee employee);

    List<Map<String, Object>> getMyEvent(@Param("uid") Long uid);

    void addEvent(@Param("params") Map<String, Object> params);

    void editEvent(@Param("params") Map<String, Object> params);

    void delEvent(@Param("eid") String eid);

    Employee getUserDetail(@Param("id") String id);

    int getCountWithLoginNo(Employee employee);

    Map<String, Object> getUserByMenuId(@Param("menuId") int menuId);

    void addUserMessage(@Param("mid") String mid, @Param("message") String message);

    int getMsgCount(@Param("uid") Long uid);

    List<Map<String,Object>> getMessage(@Param("uid") Long uid);
}
