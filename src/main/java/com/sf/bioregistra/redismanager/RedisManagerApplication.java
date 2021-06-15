package com.sf.bioregistra.redismanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisManagerApplication {

    public static void main(String[] args) {

        SpringApplication.run(RedisManagerApplication.class, args);
    }

}
