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
import java.util.List;
import java.util.Map;

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
        return new Result();
    }

    @Override
    public Result delClassify(String ids) {
        appDao.delClassify(PublicUtil.toListByIds(ids));
        return new Result();
    }
}
