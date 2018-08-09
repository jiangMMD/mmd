package com.mmt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmt.constant.SysConstants;
import com.mmt.dao.UserDao;
import com.mmt.model.Role;
import com.mmt.model.User;
import com.mmt.pjo.Page;
import com.mmt.pjo.Result;
import com.mmt.pjo.ResultPage;
import com.mmt.plugin.QueryParamInterface;
import com.mmt.service.UserService;
import com.mmt.utils.PublicUtil;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpSession session;

    @Override
    public Result login(User user) {
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        User userDb = userDao.findUserWithNameAndPass(user);
        if(userDb != null) {
            //加载用户权限信息
            if(!StringUtils.isEmpty(userDb.getRole_id())) {
                List<Role> role = userDao.getMenu(PublicUtil.toListByIds(userDb.getRole_id()));
                userDb.setRoles(role);
            }
            request.getSession().setAttribute("user", userDb);
            return new Result();
        }else{
            return new Result(0, "用户名或密码错误！");
        }
    }


    @Override
    public Result updPass(Map<String, Object> param) {
        String password = (String) param.get("password");
        //校验密码是否正确
        User user = (User) session.getAttribute("user");
        if(Objects.equals(DigestUtils.md5DigestAsHex(password.getBytes()), user.getPassword())) {
            String newpass = (String) param.get("newpassword");
            String confpass = (String) param.get("cfmpassword");
            if(newpass.length() < 4 || newpass.length() > 20 || !Objects.equals(newpass, confpass)) {
                return new Result(0, "参数异常，操作失败！");
            }
            String md5Pass = DigestUtils.md5DigestAsHex(newpass.getBytes());
            userDao.updPass(user.getUid(), md5Pass);
            //修改session中用户密码
            user.setPassword(md5Pass);
            session.setAttribute("user", user);
            return new Result();
        }else{
            return new Result(0, "密码错误，操作失败！");
        }
    }

    @Override
    public void updateUserHeadIcon(User user) {
        userDao.updateUserHeadIcon(user.getUid(), user.getHeadicon());
    }

    /**
     * 获取所有用户信息
     * @param page
     *      分页信息
     */
    @Override
    public ResultPage getAllUser(Page page, User user) {
        QueryParamInterface.setLocalPage(page);
        PageHelper.startPage(page);
        //处理查询参数问题
        List<User> list = userDao.getAllUser(user);
        return new ResultPage<>(list);
    }

    @Override
    public Result updUserInfo(User user) {
        user.setUpduser(((User)session.getAttribute("user")).getUsername());
        //校验登录名及其用户名是否重复
        User userByDb = userDao.getUserWithNoOrName(user.getUser_no(), user.getUsername(), user.getUid());
        if(userByDb == null) {
            userDao.updUserInfo(user);
        }else if(user.getUser_no().equalsIgnoreCase(userByDb.getUser_no())) {
            return new Result(0, "该登录名已存在，请更换其他登录名");
        }else if(user.getUsername().equalsIgnoreCase(userByDb.getUsername())) {
            return new Result(0, "该姓名已经存在，请尝试更换其他姓名");
        }
        return new Result();
    }

    @Override
    public void delUserInfo(String id) {
        userDao.delUserInfo(PublicUtil.toListByIds(id));
    }

    @Override
    public Result addUserInfo(User user) {
        //设置默认密码
        user.setPassword(DigestUtils.md5DigestAsHex(SysConstants.USER_PASSWORD.getBytes()));
        //设置默认头型
        user.setHeadicon(SysConstants.USER_DEFAULT_HEADICON);
        User currLoginUser = (User) session.getAttribute("user");
        user.setCrtuser(currLoginUser.getUsername());
        user.setUpduser(currLoginUser.getUsername());
        User userByDb = userDao.getUserWithNoOrName(user.getUser_no(), user.getUsername(), null);
        if(userByDb == null) {
            userDao.addUserInfo(user);
        }else if(user.getUser_no().equalsIgnoreCase(userByDb.getUser_no())) {
            return new Result(0, "该登录名已存在，请更换其他登录名");
        }else if(user.getUsername().equalsIgnoreCase(userByDb.getUsername())) {
            return new Result(0, "该姓名已经存在，请尝试更换其他姓名");
        }
        return new Result();
    }

    @Override
    public List<Role> getMenu(String role_id) {
        return userDao.getMenu(PublicUtil.toListByIds(role_id));
    }

    @Override
    public Result getMenuWithRuleIds(String role_ids) {
        return new Result(1, "查询成功！", userDao.getMenuWithRuleIds(PublicUtil.toSetByIds(role_ids)));
    }

    @Override
    public Result getMenuByRId(String role_ids) {
        return new Result(1, "查询成功！", userDao.getMenuByRId(PublicUtil.toListByIds(role_ids)));
    }

    @Override
    public Result updRoleName(Map<String, Object> params) {
        int count = userDao.queryRoleName((String) params.get("newrname"));
        if(count > 0) {
            return new Result(0, "该权限名称已存在，请更换其他名称！");
        }
        userDao.updRoleName(params);
        return new Result();
    }

    @Override
    public Result getRoleByUser(String uid) {
        return new Result(1, "查询成功！", userDao.getRoleByUser(uid));
    }

    @Override
    public Result saveUserRole(User user) {
        user.setUpduser(((User)session.getAttribute("user")).getUsername());
        userDao.saveUserRole(user);
        return new Result();
    }

    @Override
    public Result updUserIcon(String imgSrc) {
        User user = (User) session.getAttribute("user");
        user.setHeadicon(imgSrc);
        userDao.updUserIcon(user);
        return new Result();
    }

    @Override
    public Result updUserName(String username) {
        if(StringUtils.isEmpty(username)) {
            return new Result(0, "姓名不能为空");
        }
        User user = (User) session.getAttribute("user");
        user.setUsername(username);
        int count = userDao.getCountWithUserName(user);
        if(count > 0) {
            return new Result(0, "姓名已存在，请尝试更换其他,或添加其他标识");
        }
        userDao.updUserName(user);
        session.setAttribute("user", user);
        return new Result(1, "操作成功！", user);
    }

    @Override
    public Result updUserAge(Integer age) {
        if(StringUtils.isEmpty(age)) {
            return new Result(0, "年龄不能为空");
        }
        User user = (User) session.getAttribute("user");
        user.setAge(Integer.valueOf(age));
        userDao.updUserAge(user);
        session.setAttribute("user", user);
        return new Result(1, "操作成功！", user);
    }

    @Override
    public Result updUserBirthday(String birthday) {
        User user = (User) session.getAttribute("user");
        user.setBirthday(birthday);
        userDao.updUserBirthday(user);
        session.setAttribute("user", user);
        return new Result(1, "操作成功！", user);
    }

    @Override
    public Result updUserTelephone(String telephone) {
        User user = (User) session.getAttribute("user");
        user.setTelephone(telephone);
        userDao.updUserTelephone(user);
        session.setAttribute("user", user);
        return new Result(1, "操作成功！", user);
    }

    @Override
    public Result updUserCellphone(String cellphone) {
        User user = (User) session.getAttribute("user");
        user.setCellphone(cellphone);
        userDao.updUserCellphone(user);
        session.setAttribute("user", user);
        return new Result(1, "操作成功！", user);
    }

    @Override
    public Result updUserWeixin(String weixin) {
        User user = (User) session.getAttribute("user");
        user.setWeixin(weixin);
        userDao.updUserWeixin(user);
        session.setAttribute("user", user);
        return new Result(1, "操作成功！", user);
    }

    @Override
    public Result updUserQq(String qq) {
        User user = (User) session.getAttribute("user");
        user.setQq(qq);
        userDao.updUserQq(user);
        session.setAttribute("user", user);
        return new Result(1, "操作成功！", user);
    }

    @Override
    public Result getMyEvent() {
        User user = (User) session.getAttribute("user");
        return new Result(1, "查询成功", userDao.getMyEvent(user.getUid()));
    }

    @Override
    public Result addEvent(Map<String, Object> params) {
        User user = (User) session.getAttribute("user");
        params.put("uid", user.getUid());
        params.put("eid", "");
        userDao.addEvent(params);
        return new Result(1, "操作成功", params);
    }

    @Override
    public Result editEvent(Map<String, Object> params) {
        userDao.editEvent(params);
        return new Result();
    }

    @Override
    public Result delEvent(String eid) {
        userDao.delEvent(eid);
        return new Result();
    }

    @Override
    public User getUserDetail(String id) {
        return userDao.getUserDetail(id);
    }

    @Override
    public Result addOrUpdUser(User user) {
        int count = userDao.getCountWithLoginNo(user);
        if(count > 0) {
            return new Result(0, "该登录名已被使用，请尝试更换其他");
        }
        User loginUser = (User) session.getAttribute("user");
        if(user.getUid() != null) {
            user.setUpduser(loginUser.getUser_no());
            userDao.updUserInfo(user);
        }else{
            user.setCrtuser(loginUser.getUser_no());
            user.setPassword(DigestUtils.md5DigestAsHex(SysConstants.USER_PASSWORD.getBytes()));
            userDao.addUserInfo(user);
        }
        return new Result();
    }
}
