package com.mmd.service;

import com.mmd.model.Shopcat;
import com.mmd.pjo.Page;
import com.mmd.pjo.ResultPage;

import java.util.Map;

public interface ShopcatService {
    ResultPage getShopcatList(Page page, Shopcat shopcat);

    Map<String, Object> shopcatDetail(String catId);
}
