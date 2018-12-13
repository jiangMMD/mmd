package com.mmd.service.impl;

import com.mmd.dao.EvaluateDao;
import com.github.pagehelper.PageHelper;
import com.mmd.model.ProdEvaluate;
import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;
import com.mmd.service.EvaluateService;
import com.mmd.utils.PublicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EvaluateServiceImpl implements EvaluateService {

    @Autowired
    private EvaluateDao evaluateDao;

    @Override
    public ResultPage getEvaluate(Page page, ProdEvaluate prodEvaluate) {
        PageHelper.startPage(page);
        return new ResultPage<>(evaluateDao.getEvaluate(prodEvaluate));
    }

    @Override
    public ProdEvaluate getProdEvaluateDetail(String id) {
        return evaluateDao.getProdEvaluateDetail(id);
    }

    @Override
    public Result delEvaluate(String ids) {
        evaluateDao.delEvaluate(PublicUtil.toListByIds(ids));
        return new Result();
    }

    @Override
    public ResultPage getWord(Page page, ProdEvaluate prodEvaluate) {
        PageHelper.startPage(page);
        return new ResultPage<>(evaluateDao.getWord(prodEvaluate));
    }

    @Override
    public List<Map<String, Object>> getPnameByKey(String key) {
        return evaluateDao.getPnameByKey(key);
    }

    @Override
    public Result delWord(String ids) {
        String[] idArr = ids.split(",");
        String pid = "";
        for (String id: idArr) {
            Map<String, Object> map = evaluateDao.getEvalStar(id);
            pid = String.valueOf(map.get("pid"));
            evaluateDao.updateStarNum(id, (Integer) map.get("starlevel"));
            evaluateDao.delWord(id);
        }
        evaluateDao.updateAvgStar(pid);
        return new Result();
    }
}
