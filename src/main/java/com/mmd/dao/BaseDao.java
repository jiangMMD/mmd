package com.mmd.dao;

import com.mmd.model.Department;
import com.mmd.model.Menu;
import com.mmd.model.Role;
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

    List<Map<String, Object>> getAllPost();

    List<Map<String, Object>> getPropData();

    List<Map<String, Object>> getPropValByPropId(@Param("prop_id") String prop_id);

    List<Map<String, Object>> getAllClassify();

    Map<String, Object> getPriceToMMDRate();

    List<Map<String, Object>> getMerByKey(@Param("key") String key);

    List<Map<String,Object>> getFeedBack(@Param("params") Map<String, String> params);

    void dealSuggest(@Param("id") String id);

}
