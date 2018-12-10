package com.mmd.service.impl;

import com.github.pagehelper.PageHelper;
import com.mmd.dao.IntegralDao;
import com.mmd.dao.IntegralLogDao;
import com.mmd.model.Integral;
import com.mmd.model.IntegralLog;
import com.mmd.pjo.Page;
import com.mmd.pjo.ResultPage;
import com.mmd.plugin.QueryParamInterface;
import com.mmd.service.IntegralLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntegralLogServiceImpl implements IntegralLogService {
    @Autowired
    private IntegralLogDao integralLogDao;

    /**
     * 获取所有用户信息
     * @param page
     *      分页信息
     */
    @Override
    public ResultPage getIntegralLogList(Page page, IntegralLog integralLog) {
        PageHelper.startPage(page);
        //处理查询参数问题
        List<IntegralLog> list = integralLogDao.getIntegralLogList(integralLog);
        System.out.println(list.get(0));
        System.out.println(list);
        return new ResultPage<>(list);
    }

}
