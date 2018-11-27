package com.mmd.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AppDao {

    List<Map<String,Object>> getClassify(@Param("params") Map<String, String> params);

    Map<String,Object> getClassifyById(@Param("id") String id);

    void addClassify(@Param("data") Map<String, Object> data);

    void updClassify(@Param("data") Map<String, Object> data);

    void delClassify(@Param("ids") List<String> ids);
}
