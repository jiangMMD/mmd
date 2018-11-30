package com.mmd.service.impl;

import com.github.pagehelper.PageHelper;
import com.mmd.dao.UserDao;
import com.mmd.model.User;
import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;
import com.mmd.service.UserService;
import com.mmd.utils.PublicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;



    @Override
    public ResultPage<User> getUser(Page page, User user) {
        PageHelper.startPage(page);
        List<User> userList = userDao.getUser(user);
        return new ResultPage<>(userList);
    }

    @Override
    public Result delUser(String ids) {
        int usernums = userDao.getUserNumsWithCids(PublicUtil.toListByIds(ids));
        if(usernums > 0) {
            return new Result(0, "操作失败，选中的客户中有订单信息，无法删除； 如需删除，请联系管理员进行删除");
        }
        userDao.delUser(PublicUtil.toListByIds(ids));
        return new Result();

    }

    @Override
    public User getUserDetail(String uid) {
        return  userDao.getUserDetail(uid);
    }

    @Override
    public Result saveUserInfo(User user) {
        int count = userDao.checkPhone(user);
        if(count > 0) {
            return new Result(0, "该电话已存在,不可多次保存");
        }
       if(user.getuId() != null) {
           userDao.updateUser(user);
       }else{
           userDao.addUserInfo(user);
       }
        return new Result();
    }




}
