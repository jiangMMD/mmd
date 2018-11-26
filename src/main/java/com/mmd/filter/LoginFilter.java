package com.mmd.filter;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            if (req.getSession().getAttribute("employee") != null) {
                if (Objects.equals(req.getHeader("session_invalid"), "true")) {
                    //重新将头设置为未失效状态
                    res.setHeader("session_invalid", null);
                }
                //校验用户是否有访问此页面的权限, 通用页访问不需要权限， 所有用户都能访问首页, common目录下为通用页，不需要权限就可以访问
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

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
