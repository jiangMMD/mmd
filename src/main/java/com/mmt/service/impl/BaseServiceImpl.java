package com.mmt.service.impl;

import com.mmt.dao.BaseDao;
import com.mmt.dao.UserDao;
import com.mmt.model.Department;
import com.mmt.model.Iemi_turnover;
import com.mmt.model.Role;
import com.mmt.model.User;
import com.mmt.pjo.Result;
import com.mmt.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class BaseServiceImpl implements BaseService {

    @Autowired
    private BaseDao baseDao;

    @Autowired
    private UserDao userDao;

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
        int count = userDao.queryRoleName(role.getRname());
        if(count > 0) {
            return new Result(1, "该权限名称已存在，请更换其他名称！");
        }
        role.setCrtuser(((User)session.getAttribute("user")).getUsername());
        userDao.addRole(role);
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
    public Result getAllAgency() {
        return new Result(1, "查询成功！", baseDao.getAllAgency());
    }

    @Override
    public Result getAllPost() {
        return new Result(1, "查询成功！", baseDao.getAllPost());
    }

    @Override
    public Result getAllImeiWithHas(String id) {
        return new Result(1, "查询成功！", baseDao.getAllImeiWithHas(id));
    }

    @Override
    public Iemi_turnover toImeiOutdetail(String id) {
        return baseDao.toImeiOutdetail(id);
    }

    @Override
    public Iemi_turnover toImeiIndetail(String id) {
        return baseDao.toImeiIndetail(id);
    }
}
