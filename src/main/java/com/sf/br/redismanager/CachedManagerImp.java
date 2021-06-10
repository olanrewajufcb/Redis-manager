package com.sf.br.redismanager;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties(ClientConfigProperties.class)
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CachedManagerImp implements CachedManager{

    private static final Logger LOGGER = LoggerFactory.getLogger(CachedManagerImp.class);
    private ClientConfigProperties clientConfigProperties;

    private JedisConnectionFactory redisClient;
    @Value("${redis.server}")
    private String serverList;

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
//        String host = clientConfigProperties.getServername();
//        int port = clientConfigProperties.getPort();
        redisClient = new JedisConnectionFactory(new RedisStandaloneConfiguration(serverList));
        return redisClient;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory){
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory);
        return template;
    }


    @Override
    public Object getItem(String key) {
        Object obj = null;
        try {
            key = key == null ? key.replace(" ", "");
            obj = redisClient.get(key);
        }catch (Exception e){

        }
        return null;
    }

    @Override
    public <T> T getItem(String key, Class<T> returnClazz) {
        return null;
    }

    @Override
    public boolean setItem(String key, Object item, Integer age) {
        return false;
    }

    @Override
    public boolean removeItem(String key) {
        return false;
    }
}
