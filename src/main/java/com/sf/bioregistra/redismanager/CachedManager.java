package com.sf.bioregistra.redismanager;

public interface CachedManager {

//    <T> Map<Object, T> getItem(String key);
//    Object getMapAsSingleEntry(String redisKey, Object key);

    Object getValue(String key);
    <T> T getValue(String key, Class<T> returnClazz);
    boolean putValue(String key, Object item, Integer age);
   void putValue(String key, String value);
    boolean removeItem(String key);
}
