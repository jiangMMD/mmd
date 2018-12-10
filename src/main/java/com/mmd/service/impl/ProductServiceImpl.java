package com.mmd.service.impl;

import com.github.pagehelper.PageHelper;
import com.mmd.dao.ProductDao;
import com.mmd.model.ProdCarousal;
import com.mmd.model.Productsinfo;
import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;
import com.mmd.service.ProductService;
import com.mmd.utils.PublicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public Result getProClassifyByKey(String key){
        return new Result(1, "查询成功！", productDao.getProClassifyByKey(key));
    }

    @Override
    public ResultPage getProductList(Page page, Productsinfo productsinfo) {
        PageHelper.startPage(page);
        List<Productsinfo> list = productDao.getProductList(productsinfo);
        return new ResultPage<>(list);
    }

    @Override
    public Result delProduct(String ids) {
        productDao.delProduct(PublicUtil.toListByIds(ids));
        return new Result();
    }

    @Override
    public Result uplineProduct(String ids) {
        productDao.uplineProduct(PublicUtil.toListByIds(ids));
        return new Result();
    }

    @Override
    public Result downlineProduct(String ids) {
        productDao.downlineProduct(PublicUtil.toListByIds(ids));
        return new Result();
    }

    @Override
    public Productsinfo getProductDetail(String id) {
        Productsinfo productsinfo = productDao.getProductDetail(id);
        return productsinfo;
    }

    @Override
    public ProdCarousal getProdCarousal(String id) {
        ProdCarousal prodCarousal = productDao.getProdCarousal(id);
        return prodCarousal;
    }


    @Override
    public List<ProdCarousal> getProdCarousalList(String id) {
        List<ProdCarousal> carousalList = productDao.getCarousalList(id);
        return carousalList;
    }
}
