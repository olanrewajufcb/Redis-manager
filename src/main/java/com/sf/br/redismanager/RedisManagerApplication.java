package com.sf.br.redismanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ClientConfigProperties.class)
public class RedisManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisManagerApplication.class, args);
    }

}
