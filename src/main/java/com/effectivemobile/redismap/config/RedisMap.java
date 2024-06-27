package com.effectivemobile.redismap.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Component
public class RedisMap implements Map<String, String> {

    private final JedisPool pool;

    @Override
    public String get(Object key) {
        String res = null;
        try (Jedis jedis = pool.getResource()) {
            res = jedis.get((String) key);
        } catch (JedisException e) {
            log.error(e.getMessage());
        }
        return res;
    }

    @Override
    public String put(String key, String value) {
        String res = null;
        try (Jedis jedis = pool.getResource()) {
            res = jedis.set(key, value);
        } catch (JedisException e) {
            log.error(e.getMessage());
        }
        return res;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public String remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends String, ? extends String> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<String> keySet() {
        return null;
    }

    @Override
    public Collection<String> values() {
        return null;
    }

    @Override
    public Set<Entry<String, String>> entrySet() {
        return null;
    }
}
