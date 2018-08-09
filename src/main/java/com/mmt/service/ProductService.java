package com.mmt.service;

import com.github.pagehelper.PageInfo;
import com.mmt.pjo.Page;
import com.mmt.pjo.Result;
import com.mmt.pjo.ResultPage;

import java.util.Map;

public interface ProductService {
    Result getAllSkuProduct();

    Result getAllProduct();

    ResultPage getLineImeiInfo(Map<String, String> params, Page page);

    Result getSkuProductByPid(String product_id);

    Map<String,Object> getImeiDetailById(String id);

    ResultPage getOutLink(Page page, Map<String, Object> params);

    Map<String,Object> toOutLinkDet(String lid);

    Result passAuditOutProduct(Map<String, Object> params);

    Result unPassAuditOutPorduct(Map<String, Object> params);
}
