package com.mmd.service.impl;

import com.github.pagehelper.PageHelper;
import com.mmd.dao.ShopcatDao;
import com.mmd.model.Shopcat;
import com.mmd.pjo.Page;
import com.mmd.pjo.ResultPage;
import com.mmd.service.ShopcatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShopcatServiceImpl implements ShopcatService {
    @Autowired
    private ShopcatDao shopcatDao;

    /**
     * 获取所有用户信息
     * @param page
     *      分页信息
     */
    @Override
    public ResultPage getShopcatList(Page page, Shopcat shopcat) {
        PageHelper.startPage(page);
        //处理查询参数问题
        List<Shopcat> list = shopcatDao.getShopcatList(shopcat);
        System.out.println(list.get(0));
        System.out.println(list);
        return new ResultPage<>(list);
    }

    @Override
    public Map<String, Object> shopcatDetail(String catId) {
        return shopcatDao.shopcatDetail(catId);
    }

}
