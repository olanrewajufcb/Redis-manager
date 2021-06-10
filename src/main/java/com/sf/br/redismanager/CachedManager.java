package com.sf.br.redismanager;

public interface CachedManager {

    Object getItem(String key);
    <T> T getItem(String key, Class<T> returnClazz);
    boolean setItem(String key, Object item, Integer age);
    boolean removeItem(String key);
}
