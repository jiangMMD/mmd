package com.mmd.dao;
import com.mmd.model.Shipaddress;
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

    User findUserWithNameAndPass(User user);

    List<Shipaddress> queryAddress(@Param("uid") String uid);

    List<Shipaddress> queryAddressByUid(@Param("uid") String uid);

    Shipaddress getShipAddress(@Param("uid") String uid);

    void delAddress(@Param("id") String id);

    int getAddressNumsWithCids(@Param("ids") List<String> ids);

    void updAddress(Shipaddress shipaddress);

    List<Map<String, Object>> getUserByKey(@Param("key") String key);

    List<Map<String, Object>> getUserByPhone(@Param("key") String key);

    List<Map<String, Object>> getUserByName(@Param("key") String key);

    List<Map<String,Object>> getCollections(@Param("params") Map<String, String> params);
}
