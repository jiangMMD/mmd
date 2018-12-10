package com.mmd.service;

import com.mmd.model.Merchant;
import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;

public interface BusinessService {

    ResultPage getMerchantList(Page page, Merchant merchant);

    Merchant getBusinessDetail(String id);

    Result delBusiness(String ids);

    Result uplineBusiness(String ids);

    Result downlineBusiness(String ids);

    Result addOrUpdBusiness(Merchant merchant);
}
