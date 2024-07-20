package com.effectivemobile.redismap;

import com.effective.mobile_pr2.service.CsvService;
import com.effectivemobile.redismap.config.RedisMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.JedisPool;

@SpringBootApplication(scanBasePackages = "com.effective.mobile_pr2")
public class RedisMapApplication {

    @Autowired
    private CsvService csvService;

    public static void main(String[] args) {
        JedisPool jedisPool = new JedisPool("localhost", 6379);
        RedisMap map = new RedisMap(jedisPool);
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        System.out.println(map.get("key1"));
        System.out.println(map.get("key2"));
        System.out.println(map.get("key3"));

        SpringApplication.run(RedisMapApplication.class, args);
    }
}
