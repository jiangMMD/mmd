package com.mmd.service.impl;

import com.github.pagehelper.PageHelper;
import com.mmd.dao.BusinessDao;
import com.mmd.model.Merchant;
import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;
import com.mmd.service.BusinessService;
import com.mmd.utils.PublicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessDao businessDao;

    @Override
    public ResultPage getMerchantList(Page page, Merchant merchant) {
        PageHelper.startPage(page);
        List<Merchant> list = businessDao.getMerchantList(merchant);
        return new ResultPage<>(list);
    }

    @Override
    public Merchant getBusinessDetail(String id) {
        Merchant merchant = businessDao.getBusinessDetail(id);
        return merchant;
    }

    @Override
    public Result delBusiness(String ids) {
        businessDao.delBusiness(PublicUtil.toListByIds(ids));
        return new Result();
    }
}
