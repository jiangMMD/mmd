package com.mmt.service;


import com.mmt.model.Iemi_turnover;
import com.mmt.model.Role;
import com.mmt.pjo.Result;

public interface BaseService {


    Result getAllDepartment();

    Result getAllMenu();

    Result getUserByKey(String key);

    Result getAllRoleInfo();

    Result updRoleMenu(Role role);

    Result addRole(Role role);

    Result delRole(String rid);

    Result getAllCity();

    Result getAllAgency();

    Result getAllPost();

    Result getAllImeiWithHas(String id);

    Iemi_turnover toImeiOutdetail(String id);

    Iemi_turnover toImeiIndetail(String id);
}
