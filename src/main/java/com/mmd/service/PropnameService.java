package com.mmd.service;

import com.mmd.model.ProdSkupropname;
import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;

public interface PropnameService {
    ResultPage getAllProp(Page page, ProdSkupropname prodSkupropname);

    Result updPropnameInfo(ProdSkupropname prodSkupropname);

    void delPropnameInfo(String id);

    Result addPropnameInfo(ProdSkupropname prodSkupropname);
}
