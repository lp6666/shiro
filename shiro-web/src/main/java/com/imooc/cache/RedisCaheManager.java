package com.imooc.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 * User: JiaZF
 * Date: 2018/8/13
 * Time: 15:42
 * Description:
 */
public class RedisCaheManager implements CacheManager {

    @Resource
    private RedisCache redisCache;

    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return redisCache;
    }
}
