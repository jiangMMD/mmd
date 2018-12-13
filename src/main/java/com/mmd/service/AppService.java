package com.mmd.service;

import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;

import java.util.List;
import java.util.Map;

public interface AppService {

    ResultPage getClassify(Page page, Map<String, String> params);

    Map<String,Object> getClassifyById(String id);

    Result addOrUpdClassify(Map<String, Object> data);

    Result delClassify(String ids);

    Result getClassifyList();

    Result savaIntegral(Map<String, Object> ids);

    Result saveClassifyInfo(List<Map<String, Object>> data);

    Result loadJifen();

    Result getHotwordList();

    Result getHistoryList();

    Result saveHotwordInfo(List<String> map);

    Result saveRateInfo(Map<String, Object> ids);

    Result loadExchange();

    Result getCarousal();

    Result getProdByKey(String key);

    Result saveCarousel(List<Map<String, Object>> list);
}
