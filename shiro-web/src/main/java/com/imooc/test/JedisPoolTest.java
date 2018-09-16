package com.imooc.test;

import com.imooc.utils.JedisUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.SerializationUtils;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 * User: JiaZF
 * Date: 2018/8/13
 * Time: 13:57
 * Description:
 */
public class JedisPoolTest extends BaseTest {

    byte[] key = "hello".getBytes();

    @Resource
    private JedisUtil jedisUtil;

    @Test
    public void testSet(){

        byte[] value = "word".getBytes();
        jedisUtil.set(key,value);
    }

    @Test
    public void getValue(){
        System.out.println(jedisUtil.getValue("hello")+"========");
    }

    @Test
    public void testExpire(){
        jedisUtil.expire(key,2);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        byte[] bytes = jedisUtil.get(key);
        String value = new String(bytes);
        System.out.println(value+"=========");
    }
}
