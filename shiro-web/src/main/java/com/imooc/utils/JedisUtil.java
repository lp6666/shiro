package com.imooc.utils;

import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: JiaZF
 * Date: 2018/8/13
 * Time: 11:15
 * Description:
 */
@Component
public class JedisUtil {

    @Resource
    private JedisPool jedisPool;

    private Jedis getResource(){
        return jedisPool.getResource();
    }

    public byte[] set(byte[] key, byte[] value){
        Jedis jedis = getResource();
        try {
            jedis.set(key, value);
            return value;
        }finally {
            jedis.close();
        }
    }

    public void expire(byte[] key,int i) {
        Jedis jedis = getResource();

        try {
            jedis.expire(key,i);
        }finally {
            jedis.close();
        }
    }

    public byte[] get(byte[] key) {
        Jedis jedis = getResource();
        try{
            byte[] bytes = jedis.get(key);
            return bytes;
        }finally {
            jedis.close();
        }
    }

    public void del(byte[] key) {
        Jedis jedis = getResource();
        try{
       jedis.del(key);
        }finally {
            jedis.close();
        }
    }

    public Set<byte[]> keys(String key) {
        Jedis jedis = getResource();
        try{
            return jedis.keys((key + "*").getBytes());
        }finally {
            jedis.close();
        }
    }

    public String getValue(String key){
        Jedis jedis = getResource();
        try{
            return jedis.get(key);
        }finally {
            jedis.close();
        }


    }

}
