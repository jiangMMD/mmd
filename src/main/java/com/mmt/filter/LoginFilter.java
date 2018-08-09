package com.mmt.filter;

import com.mmt.constant.RedisKeyConstants;
import com.mmt.model.Menu;
import com.mmt.model.Role;
import com.mmt.model.User;
import com.mmt.utils.PropertyLoad;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

/**
 * Created by Administrator on 2017/4/14.
 */
public class LoginFilter implements HandlerInterceptor {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object o) throws Exception {
        if (req.getRequestURI().endsWith(".png")
                || req.getRequestURI().endsWith(".jpg")
                || req.getRequestURI().endsWith(".gif")
                || req.getRequestURI().endsWith(".jpeg")
                || req.getRequestURI().endsWith("/login.html")
                || req.getRequestURI().endsWith(".js")
                || req.getRequestURI().endsWith(".css")
                || req.getRequestURI().endsWith(".svg")
                || req.getRequestURI().endsWith(".eot")
                || req.getRequestURI().endsWith(".woff")
                || req.getRequestURI().endsWith(".ttf")
                || req.getRequestURI().endsWith(".ico")
                || req.getRequestURI().endsWith(".jsp")
                || req.getRequestURI().endsWith("/freightToOut") //过滤运价接口
                || req.getRequestURI().contains("/:") //处理前端页面
                || req.getRequestURI().endsWith("/login") //登录页面
                || req.getRequestURI().endsWith("/reg")   //注册页面
                || req.getRequestURI().endsWith(".php")//不拦截.php请求
                || req.getRequestURI().endsWith(".pc")//不拦截pc客户端的接口请求
                || req.getRequestURI().contains("test")//不拦截pc客户端的接口请求
                || req.getRequestURI().endsWith("/ws")//不拦截socket请求
                ) {
            return true;
        } else {
            if (req.getSession().getAttribute("user") != null) {
                if (Objects.equals(req.getHeader("session_invalid"), "true")) {
                    //重新将头设置为未失效状态
                    res.setHeader("session_invalid", null);
                }
                //校验用户是否有访问此页面的权限, 通用页访问不需要权限， 所有用户都能访问首页, common目录下为通用页，不需要权限就可以访问
                if (req.getRequestURI().endsWith(".html")
                        && !req.getRequestURI().endsWith("index.html")
                        && !StringUtils.contains(req.getRequestURI(), "/common/")) {
                    User user = (User) req.getSession().getAttribute("user");
                    if (user.getIsadmin() != null && user.getIsadmin()) {
                        //如果用户为管理员，那么直接返回
                        return true;
                    }
                    //监测用户权限
                    String url = req.getRequestURI().substring(req.getRequestURI().indexOf("content") + 8).replace(".html", "");
                    if (!hasUserRole(user.getRoles(), url)) {
                        //用户没有该权限页面, 需要判断该页面为404，还是权限不够
                        //如果权限不够，那么修改状态码， 否则直接返回
                        if (redisTemplate.opsForSet().isMember(RedisKeyConstants.MENU_KEY, url)) {
                            //说明有该页面，表示没有权限, 那么拒绝响应
                            req.getRequestDispatcher("/content/common/error-403.html").forward(req, res);
                            return false;
                        } else {
                            //说明没有改页面
//                            if ("pro".equals(PropertyLoad.getProperty("environment"))) {
//                                //没有找到该页面
//                                req.getRequestDispatcher("/content/common/error-404.html").forward(req, res);
//                                return false;
//                            }
                        }
                    } else {
                        //找到该页面，那么加载
                        return true;
                    }
                }
                return true;
            } else {
                res.setHeader("session_invalid", "true");
                //判断如果是ajax请求，那么返回401
                if (Objects.equals(req.getHeader("X-Requested-With"), "XMLHttpRequest")) {
                    res.setStatus(HttpStatus.SC_UNAUTHORIZED);
                } else {
                    req.getRequestDispatcher("/login.html").forward(req, res);
                }
                return false;
            }
        }
    }

    private boolean hasUserRole(List<Role> roles, String url) {
        for (Role role : roles) {
            List<Menu> menus = role.getMenuList();
            if (executeFor(menus, url)) {
                return true;
            }
        }
        return false;
    }

    private boolean executeFor(List<Menu> menus, String url) {
        for (Menu menu : menus) {
            if (menu.getChildMenu() != null) {
                if (executeFor(menu.getChildMenu(), url)) {
                    return true;
                }
            } else if (Objects.equals(menu.getMurl(), url)) {
                return true;
            }
        }
        return false;
    }



    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
