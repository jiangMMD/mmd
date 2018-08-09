package com.mmt.tasks;

import com.mmt.controll.BaseControll;
import com.mmt.dao.BaseDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * 定时清除缓存的iemi
 */
@Component
@Transactional
public class ClearUnUsedIemi {

    private Logger logger = LoggerFactory.getLogger(ClearUnUsedIemi.class);

    @Autowired
    private BaseDao baseDao;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 没5分钟执行一次
     */
    @Scheduled( cron = "0 0/5 * * * ? ")
    public void task() throws SQLException {
        logger.info("----------开始执行解锁IMEI任务-----------");
        //获取所有的尚在锁定中的imei
        List<String> list = redisTemplate.opsForValue().multiGet(redisTemplate.keys("imei_*"));
        //获取所有已加入锁定的imei。
        Set<String> imeiList = redisTemplate.opsForSet().members("imeiList");
        //获取所有已解锁的imei
        imeiList.removeAll(list);
        try {
            if(imeiList.size() > 0) {
                baseDao.unLockIemi(imeiList);
                //移除原有redis锁住的iemi
                redisTemplate.opsForSet().remove("imeiList", imeiList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            throw new SQLException(e);
        }
    }

}
