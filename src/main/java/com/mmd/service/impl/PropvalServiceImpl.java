package com.mmd.service.impl;

import com.mmd.dao.PropvalDao;
import com.mmd.model.ProdSkupropval;
import com.mmd.service.PropvalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PropvalServiceImpl implements PropvalService {
    @Autowired
    private PropvalDao propvalDao;

    @Override
    public Map<String, Object> getPropValDetail(String id) {
        return propvalDao.getPropValDetail(id);
    }
}
