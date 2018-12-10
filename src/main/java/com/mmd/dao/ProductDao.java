package com.mmd.dao;

import com.mmd.model.ProdCarousal;
import com.mmd.model.Productsinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductDao {
    List<Map<String, Object>> getProClassifyByKey(@Param("key") String key);

    List<Productsinfo> getProductList(Productsinfo productsinfo);

    void delProduct(@Param("ids") List<String> strings);

    void uplineProduct(@Param("ids") List<String> strings);

    void downlineProduct(@Param("ids") List<String> strings);

    Productsinfo getProductDetail(@Param("id") String id);

    ProdCarousal getProdCarousal(@Param("id") String id);

    List<ProdCarousal> getCarousalList(String id);
}
