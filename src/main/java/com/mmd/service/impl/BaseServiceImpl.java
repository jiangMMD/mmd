package com.mmd.service.impl;

import com.github.pagehelper.PageHelper;
import com.mmd.dao.BaseDao;
import com.mmd.dao.EmployeeDao;
import com.mmd.model.Department;
import com.mmd.model.Employee;
import com.mmd.model.Role;
import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;
import com.mmd.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Service
public class BaseServiceImpl implements BaseService {

    @Autowired
    private BaseDao baseDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private HttpSession session;

    @Override
    public Result getAllDepartment() {
        List<Department> list = baseDao.getAllDepartment();
        return new Result(1, "查找成功！", list);
    }

    @Override
    public Result getAllMenu() {
        return new Result(1, "查询成功！", baseDao.getAllMenuOrder());
    }

    @Override
    public Result getUserByKey(String key) {
        return new Result(1, "查询成功！", baseDao.getUserByKey(key));
    }

    @Override
    public Result getAllRoleInfo() {
        return new Result(1, "查询成功！", baseDao.getAllRoleInfo());
    }

    @Override
    public Result updRoleMenu(Role role) {
        baseDao.updRoleMenu(role);
        return new Result();
    }

    @Override
    public Result addRole(Role role) {
        int count = employeeDao.queryRoleName(role.getRname());
        if(count > 0) {
            return new Result(1, "该权限名称已存在，请更换其他名称！");
        }
        role.setCrtuser(((Employee)session.getAttribute("employee")).getName());
        employeeDao.addRole(role);
        return new Result(1, "操作成功", role.getRid());
    }

    @Override
    public Result delRole(String rid) {
        baseDao.delRole(rid);
        return new Result();
    }

    @Override
    public Result getAllCity() {
        return new Result(1, "查询成功！", baseDao.getAllCity());
    }

    @Override
    public Result getAllPost() {
        return new Result(1, "查询成功！", baseDao.getAllPost());
    }

    @Override
    public Result getPropData() {
        return new Result(1, "查询成功！", baseDao.getPropData());
    }

    @Override
    public Result getPropValByPropId(String prop_id) {
        return new Result().success(baseDao.getPropValByPropId(prop_id));
    }

    @Override
    public Result getAllClassify() {
        return new Result().success(baseDao.getAllClassify());
    }

    @Override
    public Result getPriceToMMDRate() {
        return new Result().success(baseDao.getPriceToMMDRate());
    }

    @Override
    public Result getMerByKey(String key) {
        return new Result().success(baseDao.getMerByKey(key));

    }

    @Override
    public ResultPage getFeedBack(Map<String, String> params, Page page) {
        PageHelper.startPage(page);
        List<Map<String, Object>> list = baseDao.getFeedBack(params);
        return new ResultPage(list);
    }

    @Override
    public Result dealSuggest(String id) {
        baseDao.dealSuggest(id);
        return new Result();
    }

}
