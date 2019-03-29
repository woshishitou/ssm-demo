package com.hisen.service.util.impl;

import com.hisen.service.util.RedisTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.TimeUnit;

/**
 * @描述:
 * @作者: wyl
 * @时间: 2018-03-20 9:31
 */
@SuppressWarnings("unchecked")
@Service
@Transactional
public class RedisTemplateUtilImpl implements RedisTemplateUtil {

    @Autowired
    private RedisTemplate redisTemplate;
    /**  
     * @描述: 指定缓存失效时间（秒）  
     * @作者: wyl
     * @时间: 2018/3/20 9:36  
     */ 
    @Override
    public boolean expireSeconds(String key, long times) {
        try {
            if (times > 0) {
                redisTemplate.expire(key, times, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**  
     * @描述: 获取key过期时间（秒）  
     * @作者: wyl
     * @时间: 2018/3/20 9:36  
     */ 
    @Override
    public long getExpireSeconds(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**  
     * @描述: 判断key是否存在
     * @作者: wyl
     * @时间: 2018/3/20 9:36  
     */ 
    @Override
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**  
     * @描述: 删除key 可以穿多个key值  
     * @作者: wyl
     * @时间: 2018/3/20 9:36  
     */ 
    @Override
    public void deleteKey(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    /**  
     * @描述: 通过key获取缓存
     * @作者: wyl
     * @时间: 2018/3/20 10:08
     */ 
    @Override
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * @描述: 添加缓存 时间默认
     * @作者: wyl
     * @时间: 2018/3/20 10:08
     */
    @Override
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @描述: 添加缓存 时间自定义(秒)
     * @作者: wyl
     * @时间: 2018/3/20 10:09
     */
    @Override
    public boolean set(String key, Object value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @描述: 添加缓存 自定义时间及时间单位
     * @作者: wyl
     * @时间: 2018/3/20 10:11
     */
    @Override
    public boolean set(String key, Object value, long time, TimeUnit timeUnit) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, timeUnit);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
