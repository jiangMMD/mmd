package com.mmd.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 路由控制类
 */
@RequestMapping()
@Controller
public class RouterControll {

    @Autowired
    private HttpSession session;

    @RequestMapping("/loginOut")
    public String loginOut() {
        session.removeAttribute("employee");
        return "redirect:login.html";
    }
}
