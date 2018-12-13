package com.mmd.service.impl;

import com.github.pagehelper.PageHelper;
import com.mmd.dao.AppDao;
import com.mmd.model.Employee;
import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;
import com.mmd.plugin.QueryParamInterface;
import com.mmd.service.AppService;
import com.mmd.utils.PublicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

@Service
public class AppServiceImpl implements AppService {

    @Autowired
    private AppDao appDao;

    @Autowired
    private HttpSession session;
    /**
     * 获取APP菜单分类信息
     * @param page
     * @param params
     * @return
     */
    @Override
    public ResultPage getClassify(Page page, Map<String, String> params) {
        QueryParamInterface.setLocalPage(page);
        PageHelper.startPage(page);
        List<Map<String, Object>> list = appDao.getClassify(params);
        return new ResultPage<>(list);
    }

    @Override
    public Map<String, Object> getClassifyById(String id) {
        return appDao.getClassifyById(id);
    }

    @Override
    public Result addOrUpdClassify(Map<String, Object> data) {
        Employee employee = (Employee) session.getAttribute("employee");
        System.out.println(data);
        if(data.get("dict_id") == null) {
            data.put("crtuser", employee.getName());
            appDao.addClassify(data);
        }else {
            data.put("upduser", employee.getName());
            appDao.updClassify(data);
        }
        return new Result(1,"发布成功");
    }

    @Override
    public Result delClassify(String ids) {
        appDao.delClassify(PublicUtil.toListByIds(ids));
        return new Result();
    }

    @Override
    public Result getClassifyList() {
        return new Result(1, "查询成功", appDao.getClassifyList());
    }

    @Override
    public Result savaIntegral(Map<String, Object> integral) {
        appDao.updIntegralByLogin(integral);
        appDao.updIntegralByBuy(integral);
        return new Result(1,"发布成功");
    }

    @Override
    public Result loadJifen() {
        return new Result(1, "查询成功", appDao.loadJifen());
    }

    @Override
    public Result getHotwordList() {
        return new Result(1,"查询成功",appDao.getHotwordList());
    }

    @Override
    public Result getHistoryList() {
        return  new Result(1,"查询成功" ,appDao.getHistoryList());
    }

    @Override
    public Result saveHotwordInfo(List<String> map) {
       appDao.delHotword();
       appDao.insertHotword(new TreeSet<>(map));
        return new Result(1,"发布成功");
    }

    @Override
    public Result saveRateInfo(Map<String, Object> rateinfo) {
        appDao.updRateinfoByRMB(rateinfo);
        appDao.updRateinfoByIntegral(rateinfo);
        return new Result(1,"发布成功");
    }


    @Override
    public Result loadExchange() {
        return new Result(1,"查询成功",appDao.loadExchange());
    }

    @Override
    public Result getCarousal() {
        return new Result(1, "查询成功!",appDao.getCarousal());
    }

    @Override
    public Result getProdByKey(String key) {
        return new Result(1, "查询成功！", appDao.getProdByKey(key));
    }

    @Override
    public Result saveCarousel(List<Map<String, Object>> list) {
        for(Map<String, Object> map : list) {
            appDao.updateCarousel(map);
        }
        return new Result();
    }


    @Override
    public Result saveClassifyInfo(List<Map<String, Object>> data){
        List<String> ids = new ArrayList<>();
        for(Map<String, Object> map : data) {
            if(PublicUtil.isEmptyObj(map.get("id"))) {
                appDao.insertClassify(map);
            }else{
                appDao.updateClassify(map);
            }
            ids.add(String.valueOf(map.get("id")));
        }
        appDao.delClassifyInfo(ids);
        return new Result(1,"发布成功");
    }




}
