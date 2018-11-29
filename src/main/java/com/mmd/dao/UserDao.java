package com.mmd.dao;

import com.mmd.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> getUser(User user);

    int getUserNumsWithCids(@Param("ids") List<String> ids);

    void delUser(@Param("ids") List<String> ids);

    User getUserDetail(@Param("uid") String uid);

    void addUserInfo(User user);

    void updateUser(User user);

    int checkPhone(User user);

    List<Map<String, Object>> getUserByKey(@Param("key") String key);
}
