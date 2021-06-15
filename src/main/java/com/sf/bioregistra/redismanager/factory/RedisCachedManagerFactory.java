package com.sf.bioregistra.redismanager.factory;

import com.sf.bioregistra.redismanager.CachedManager;
import com.sf.bioregistra.redismanager.CachedManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public final class RedisCachedManagerFactory {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public CachedManager createRedisCachedManager(){

        return new CachedManagerImpl(redisTemplate);
    }
}
