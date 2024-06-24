package com.effectivemobile.redismap;

import com.effectivemobile.redismap.config.RedisMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class RedisMapApplication {
    public static void main(String[] args) {
        RedisMap map = new RedisMap("localhost", 6379);
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        System.out.println(map.get("key1"));
        System.out.println(map.get("key2"));
        System.out.println(map.get("key3"));

        SpringApplication.run(RedisMapApplication.class, args);
    }
}
