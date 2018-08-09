package com.mmt.dao;

import com.mmt.model.Custom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomDao {
    List<Custom> getCustom(Custom custom);

    int getBookNumsWithCids(@Param("ids") List<String> ids);

    void delCustom(@Param("ids") String ids);

    Custom getCustomDetail(@Param("cid") String cid);

    void updateCustom(Custom custom);
}
