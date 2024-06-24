package com.effectivemobile.redismap.config;

import com.github.fppt.jedismock.RedisServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RedisMapTest {

    private static RedisServer server = null;

    @BeforeAll
    public static void before() throws IOException {
        server = RedisServer
                .newRedisServer()
                .start();
    }

    @Test
    public void smoke_test() {
        RedisMap redisMap = new RedisMap(server.getHost(), server.getBindPort());
        redisMap.put("key1", "value1");
        assertNotNull(redisMap.get("key1"));
        assertEquals("value1", redisMap.get("key1"));
    }

    @AfterAll
    public static void after() throws IOException {
        server.stop();
        server = null;
    }

}
