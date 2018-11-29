package com.mmd.service;

import com.mmd.model.User;
import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;

import java.util.List;
import java.util.Map;


public interface UserService {
    ResultPage<User> getUser(Page page, User user);

    Result delUser(String ids);

    User getUserDetail(String uid);

    Result saveUserInfo(User user);


    List<Map<String,Object>> getUserByKey(String key);
}
