package com.mmt.service;

import com.mmt.model.Agency;
import com.mmt.pjo.Page;
import com.mmt.pjo.Result;
import com.mmt.pjo.ResultPage;

public interface AgencyService {

    ResultPage<Agency> getAgencyList(Agency agency, Page page);

    Agency getAgencyDetail(String id);

    Result saveAgencyInfo(Agency agency);

    int getAgencyWithLoginNo(Agency agency);

    Result delAgency(String ids);
}
