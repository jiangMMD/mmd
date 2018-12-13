package com.mmd.service;

import com.mmd.model.ProdCarousal;
import com.mmd.model.Productsinfo;
import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;

import java.util.List;
import java.util.Map;

public interface ProductService {
    Result getProClassifyByKey(String key);

    ResultPage getProductList(Page page, Productsinfo productsinfo);

    Result delProduct(String ids);

    Result uplineProduct(String ids);

    Result downlineProduct(String ids);

    Productsinfo getProductDetail(String id);

    ProdCarousal getProdCarousal(String id);

    List<ProdCarousal> getProdCarousalList(String id);

    List<Map<String,Object>> getProdService(String id);

    List<Map<String,Object>> getProdSku(String id);

    List<Map<String,Object>> getAllProdService(String serviceIds);

    List<Map<String,Object>> getProdParamImg(String id);

    Result getProdSkuDetail(String sku_id);

    Result saveProdSku(Map<String, Object> params);

    Result delProdSku(String sku_id, String pid);

    Result addOrUpdProd(Productsinfo productsinfo);

    Result uploadCarousel(String filename, String goods_url, String pid);

    Result delCarousel(String filename, String pid);
}
