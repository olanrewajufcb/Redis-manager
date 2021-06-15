package com.sf.bioregistra.redismanager;


import io.lettuce.core.RedisException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@Configuration
public class CachedManagerImpl implements CachedManager{

    private static final Logger LOGGER = LoggerFactory.getLogger(CachedManagerImpl.class);
    @Autowired
    private final RedisTemplate<String, Object> redisTemplate;
    private final HashOperations<String, Object, Object> hashOperations;
    private ListOperations<String, Object> listOperations;
    private final ValueOperations<String, Object> valueOperations;

    public CachedManagerImpl(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
        this.listOperations = redisTemplate.opsForList();
        this.valueOperations = redisTemplate.opsForValue();
    }

    @Override
    public Object getValue(String key) {

        Object obj = null;
        try {
            key = key == null ? key : key.replace(" ", "");
            assert key != null;
            obj = valueOperations.get(key);
        } catch (RedisException exception) {
            LOGGER.error("-------< Exception retrieving item from memcached: {} >-------", exception.getMessage());
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getValue(String key, Class<T> returnClazz) {
        return (T) valueOperations.get(returnClazz);
    }

    @Override
    public void putValue(String key, String value) {
        valueOperations.set(key, value);
    }

    @Override
    public boolean putValue(String key, Object item, Integer age) {
        boolean success = false;
        try {
            key = key == null ? key : key.replace(" ", "");
            valueOperations.set(key, item, age);
            success = true;
        }catch (RedisException exception) {
            LOGGER.error("-------< Exception putting item in memcached: {} >-------", exception.getMessage());
            Thread.currentThread().interrupt();
        }
        return success;
    }

    @Override
    public boolean removeItem(String key) {
        boolean success = false;
        try {
                hashOperations.delete(key);
                success = true;

        } catch (RedisException exception) {
            LOGGER.error("-------< Exception removing item in memcached: {} >-------", exception.getMessage());
            Thread.currentThread().interrupt();
        }
        return success;
    }
}
