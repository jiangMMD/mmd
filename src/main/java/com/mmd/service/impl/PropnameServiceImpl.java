package com.mmd.service.impl;

import com.github.pagehelper.PageHelper;
import com.mmd.constant.SysConstants;
import com.mmd.dao.PropnameDao;
import com.mmd.dao.PropvalDao;
import com.mmd.model.ProdSkupropname;
import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;
import com.mmd.plugin.QueryParamInterface;
import com.mmd.service.PropnameService;
import com.mmd.utils.PublicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
@Service
public class PropnameServiceImpl implements PropnameService {
    @Autowired
    private PropnameDao propnameDao;
    @Autowired
    private PropvalDao propvalDao;


    @Override
    public ResultPage getAllProp(Page page, ProdSkupropname prodSkupropname) {
        QueryParamInterface.setLocalPage(page);
        PageHelper.startPage(page);
        List<ProdSkupropname> list = propnameDao.getAllProp(prodSkupropname);
        System.out.println(list);
        return new ResultPage<>(list);
    }


    @Override
    public Result updPropnameInfo(ProdSkupropname prodSkupropname) {
            propnameDao.updPropnameInfo(prodSkupropname);
        return new Result();
    }

    @Override
    public void delPropnameInfo(String id) {
        propnameDao.delPropnameInfo(PublicUtil.toListByIds(id));
    }

    @Override
    public Result addPropnameInfo(ProdSkupropname prodSkupropname) {
        ProdSkupropname prodSkupropnameDb = propnameDao.getPropByName(prodSkupropname.getPropName());
        if(prodSkupropnameDb == null) {
            propnameDao.addPropnameInfo(prodSkupropname);
        }else {
            return new Result(0, "该属性名名已存在");
        }
        return new Result();
    }
}
