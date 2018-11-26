package com.mmd.service;


import com.mmd.model.Role;
import com.mmd.pjo.Result;

public interface BaseService {


    Result getAllDepartment();

    Result getAllMenu();

    Result getUserByKey(String key);

    Result getAllRoleInfo();

    Result updRoleMenu(Role role);

    Result addRole(Role role);

    Result delRole(String rid);

    Result getAllCity();

    Result getAllPost();

}
