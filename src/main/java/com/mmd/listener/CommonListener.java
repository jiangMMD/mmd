package com.mmd.listener;

import com.mmd.constant.RedisKeyConstants;
import com.mmd.dao.BaseDao;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.context.ContextLoader;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

/**
 * Created by Administrator on 2017/6/27.
 */

public class CommonListener implements ServletContextListener {

    private static Logger logger = Logger.getLogger(CommonListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
//        ApplicationContext context =  ContextLoader.getCurrentWebApplicationContext();
//        BaseDao baseDao = context.getBean(BaseDao.class);
//        List<Menu> listMenu = baseDao.getAllMenu();
//        RedisTemplate redisTemplate = context.getBean(RedisTemplate.class);
//        redisTemplate.delete(RedisKeyConstants.MENU_KEY);
//        for (Menu menu : listMenu) {
//            redisTemplate.opsForSet().add(RedisKeyConstants.MENU_KEY, menu.getMurl());
//        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
