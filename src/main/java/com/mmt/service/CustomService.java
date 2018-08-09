package com.mmt.service;

import com.mmt.model.Custom;
import com.mmt.pjo.Page;
import com.mmt.pjo.Result;
import com.mmt.pjo.ResultPage;

public interface CustomService {

    ResultPage<Custom> getCustom(Page page, Custom custom);

    Result delCustom(String ids);

    Custom getCustomDetail(String cid);

    Result saveCustom(Custom custom);
}
