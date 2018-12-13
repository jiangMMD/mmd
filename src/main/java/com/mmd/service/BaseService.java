package com.mmd.service;


import com.mmd.model.Role;
import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;

import java.util.Map;

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

    ResultPage getFeedBack(Map<String, String> params, Page page);

    Result dealSuggest(String id);

}
