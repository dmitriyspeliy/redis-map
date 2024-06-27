package com.effectivemobile.redismap.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

    @Value("${spring.redis.port:6379}")
    private int port;

    @Value("${spring.redis.host:localhost}")
    private String host;

    @Value("${spring.redis.jedis.pool.max-active:0}")
    private int maxActive;

    @Value("${spring.redis.jedis.pool.max-idle:0}")
    private int maxIdle;

    @Bean
    public JedisPool jedisPoolCreate() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxActive);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setJmxEnabled(false);
        return new JedisPool(jedisPoolConfig, host, port);
    }



}
