package com.mmd.dao;

import com.mmd.model.ProdCarousal;
import com.mmd.model.Productsinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProductDao {
    List<Map<String, Object>> getProClassifyByKey(@Param("key") String key);

    List<Productsinfo> getProductList(Productsinfo productsinfo);

    void delProduct(@Param("ids") List<String> strings);

    void uplineProduct(@Param("ids") List<String> strings);

    void downlineProduct(@Param("ids") List<String> strings);

    Productsinfo getProductDetail(@Param("id") String id);

    ProdCarousal getProdCarousal(@Param("id") String id);

    List<ProdCarousal> getCarousalList(@Param("id") String id);

    List<Map<String,Object>> getProdService(@Param("id") String id);

    List<Map<String,Object>> getProdSku(@Param("id") String id);

    Map<String,Object> getProdPropBySku(@Param("parMap") Map<String, String> parMap);

    List<Map<String,Object>> getAllProdService(@Param("serviceIds") String serviceIds);

    List<Map<String,Object>> getProdParamImg(@Param("id") String id);

    Map<String, Object> getProdSkuDetail(@Param("sku_id") String sku_id);

    void insertSku(@Param("params") Map<String, Object> params);

    void updateSku(@Param("params") Map<String, Object> params);

    List<String> getAllProdSkuVals(@Param("pid") String pid);

    void delAllSkuRel(@Param("pid") String pid);

    void insertSkuRel(@Param("set") Set<Map<String, String>> set, @Param("pid") String pid);

    void delProdSku(@Param("sku_id") String sku_id);

    void updateProd(Productsinfo productsinfo);

    void addProd(Productsinfo productsinfo);

    void uploadCarousel(@Param("goods_url") String goods_url, @Param("pid") String pid);

    void delCarousel(@Param("url") String url, @Param("filename") String filename, @Param("pid") String pid);

    void uploadDetailImg(@Param("goods_url") String goods_url, @Param("pid") String pid);

    void delDetailimg(@Param("url") String url, @Param("filename") String filename, @Param("pid") String pid);

    void updateProdStore(@Param("pid") String pid);
}
