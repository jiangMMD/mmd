package com.mmd.dao;

import com.mmd.model.Shopcat;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ShopcatDao {
    List<Shopcat> getShopcatList(Shopcat shopcat);

    Map<String, Object> shopcatDetail(@Param("catId") String catId);
}
