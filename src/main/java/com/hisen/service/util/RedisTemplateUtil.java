package com.hisen.service.util;

import java.util.concurrent.TimeUnit;

/**
 * @描述:
 * @作者: wyl
 * @时间: 2018-03-20 9:31
 */
public interface RedisTemplateUtil {

    /**
     * @描述: 指定缓存失效时间（秒）
     * @作者: wyl
     * @时间: 2018/3/20 9:32
     */
    boolean expireSeconds(String key, long times);

    /**
     * @描述: 获取key过期时间（秒）
     * @作者: wyl
     * @时间: 2018/3/20 9:32
     */
    long getExpireSeconds(String key);

    /**
     * @描述: 判断key是否存在
     * @作者: wyl
     * @时间: 2018/3/20 9:33
     */
    boolean hasKey(String key);

    /**
     * @描述: 删除key 可以穿多个key值
     * @作者: wyl
     * @时间: 2018/3/20 9:34
     */
    void deleteKey(String... key);

    /**
     * @描述: 通过key获取缓存
     * @作者: wyl
     * @时间: 2018/3/20 9:34
     */
    Object get(String key);

    /**
     * @描述: 添加缓存 时间默认
     * @作者: wyl
     * @时间: 2018/3/20 9:35
     */
    boolean set(String key, Object value);

    /**
     * @描述: 添加缓存 时间自定义(秒)
     * @作者: wyl
     * @时间: 2018/3/20 9:35
     */
    boolean set(String key, Object value, long time);

    /**
     * @描述: 添加缓存 自定义时间及时间单位
     * @作者: wyl
     * @时间: 2018/3/20 9:35
     */
    boolean set(String key, Object value, long time, TimeUnit timeUnit);
}
