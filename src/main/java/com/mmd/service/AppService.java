package com.mmd.service;

import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;

import java.util.Map;

public interface AppService {

    ResultPage getClassify(Page page, Map<String, String> params);

    Map<String,Object> getClassifyById(String id);

    Result addOrUpdClassify(Map<String, Object> data);
}
