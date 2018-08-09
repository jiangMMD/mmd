package com.mmt.plugin;

import com.alibaba.fastjson.JSON;
import com.mmt.listener.CommonListener;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;

/**
 * Created by xinghb on 2017/10/26.
 */
@Component
public class JedisHelper {
    private static Logger logger = Logger.getLogger(JedisHelper.class);

    @Autowired
    private RedisTemplate<Serializable, Object> redisTemplate;

    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    public void remove(final String key) {
        if(exites(key)) {
            redisTemplate.delete(key);
        }
    }

    public boolean exites(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 获取数据
     * @param key
     * @return
     */
    public Object get(final String key) {
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }

    /**
     * 存入数据
     */
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            logger.error("set cache error", e);
        }
        return result;
    }

    /**
     * 写入数据，具有失效时间
     */
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            logger.error("set cache error", e);
        }
        return result;
    }

    //设置增加
    public long increment(final String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }
}
