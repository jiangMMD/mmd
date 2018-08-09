package com.mmt.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductDao {

    List<Map<String,Object>> getAllSkuProduct();

    List<Map<String,Object>> getAllProduct();

    List<Map<String, Object>> getLineImeiInfo(@Param("params") Map<String, String> params);

    List<Map<String,Object>> getSkuProductByPid(@Param("product_id") String product_id);

    Map<String,Object> getImeiDetailById(@Param("id") String id);

    List<Map<String,Object>> getOutLink(@Param("params") Map<String, Object> params);

    Map<String,Object> toOutLinkDet(@Param("lid") String lid);

    void passAuditOutPorduct(@Param("params") Map<String, Object> params);

    void insertNotityWithOutProduct(@Param("params") Map<String, Object> params);

    void insertNotityWithUnPassOutProduct(@Param("params") Map<String, Object> params);

    void unpassAuditOutProduct(@Param("params") Map<String, Object> params);
}
