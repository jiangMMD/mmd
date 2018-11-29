package com.mmd.dao;

import com.mmd.model.Shipaddress;
import com.mmd.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    List<User> getUser(User user);

    User findUserWithNameAndPass(User user);

    int getUserNumsWithCids(@Param("ids") List<String> ids);

    void delUser(@Param("ids") List<String> ids);

    void addUserInfo(User user);

    void updateUser(User user);

    int checkPhone(User user);

    User getUserDetail(@Param("uid") String uid);

    List<Shipaddress> queryAddress(@Param("uid") String uid);

    List<Shipaddress> queryAddressByUid(@Param("uid") String uid);

    Shipaddress getShipAddress(@Param("uid") String uid);

    void delAddress(@Param("id") String id);

    int getAddressNumsWithCids(@Param("ids") List<String> ids);

    void updAddress(Shipaddress shipaddress);



}
