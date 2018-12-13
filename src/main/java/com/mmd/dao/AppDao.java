package com.mmd.dao;

import com.mmd.model.Integral;
import com.mmd.model.Rateinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public interface AppDao {

    List<Map<String,Object>> getClassify(@Param("params") Map<String, String> params);

    Map<String,Object> getClassifyById(@Param("id") String id);

    void addClassify(@Param("data") Map<String, Object> data);

    void updClassify(@Param("data") Map<String, Object> data);

    void delClassify(@Param("ids") List<String> ids);

    List<Map<String, Object>> getClassifyList();

    List<Integral> loadJifen();

    void updIntegralByLogin(@Param("integral") Map<String, Object> integral);

    void updIntegralByBuy(@Param("integral") Map<String, Object> integral);

    void insertClassify(@Param("map") Map<String, Object> map);

    void updateClassify(@Param("map") Map<String, Object> map);

    void delClassifyInfo(@Param("ids") List<String> ids);

    List<Map<String,Object>> getHotwordList();

    List<Map<String,Object>> getHistoryList();

    void insertHotword(@Param("map") TreeSet<String> map);

    void delHotword();

    void updRateinfoByRMB(@Param("rateinfo") Map<String, Object> rateinfo);

    void updRateinfoByIntegral(@Param("rateinfo") Map<String, Object> rateinfo);

    List<Rateinfo> loadExchange();


    List<Map<String, Object>> getCarousal();

    List<Map<String, Object>> getProdByKey(@Param("key") String key);

    void updateCarousel(@Param("map") Map<String, Object> map);
}
