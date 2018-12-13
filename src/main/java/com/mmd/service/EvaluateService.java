package com.mmd.service;

import com.mmd.model.ProdEvaluate;
import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;

import java.util.List;
import java.util.Map;

public interface EvaluateService {
    ResultPage getEvaluate(Page page, ProdEvaluate prodEvaluate);

    ProdEvaluate getProdEvaluateDetail(String id);

    Result delEvaluate(String ids);

    ResultPage getWord(Page page,ProdEvaluate prodEvaluate);

    List<Map<String,Object>> getPnameByKey(String key);

    Result delWord(String ids);

}
