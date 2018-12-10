package com.mmd.service;

import com.mmd.model.ProdCarousal;
import com.mmd.model.Productsinfo;
import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;

import java.util.List;

public interface ProductService {
    Result getProClassifyByKey(String key);

    ResultPage getProductList(Page page, Productsinfo productsinfo);

    Result delProduct(String ids);

    Result uplineProduct(String ids);

    Result downlineProduct(String ids);

    Productsinfo getProductDetail(String id);

    ProdCarousal getProdCarousal(String id);

    List<ProdCarousal> getProdCarousalList(String id);
}
