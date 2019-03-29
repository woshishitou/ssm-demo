package com.hisen.test;

import com.hisen.service.util.RedisTemplateUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zlb
 * @description:
 * @date 2019/3/12 0:31
 */
public class RedisTest extends BaseTest {

    @Autowired
    private RedisTemplateUtil redisTemplateUtil;

    @Test
    public void test() {
        System.out.println((String)redisTemplateUtil.get("redis"));
        System.out.println((String)redisTemplateUtil.get("red"));
        redisTemplateUtil.set("redis", "哈哈哈哈哈，redis全部弄好了，可以用了喽");
    }

}
