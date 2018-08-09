package com.mmt.dao;

import com.mmt.model.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface BaseDao {

    List<Department> getAllDepartment();

    List<Menu> getAllMenu();
    //查询按父子关系排序之后的所有菜单信息
    List<Menu> getAllMenuOrder();

    List<Map<String, Object>> getUserByKey(@Param("key") String key);

    List<Role> getAllRoleInfo();

    void updRoleMenu(Role role);

    void delRole(@Param("rid") String rid);

    List<Map<String, Object>> getAllCity();

    List<Agency> getAllAgency();

    List<Map<String, Object>> getAllPost();

    List<Iemi> getAllImeiWithHas(@Param("id") String id);

    Iemi_turnover toImeiOutdetail(@Param("id") String id);

    Iemi_turnover toImeiIndetail(@Param("id") String id);

    void unLockIemi(@Param("imeiList") Set<String> imeiList);
}
