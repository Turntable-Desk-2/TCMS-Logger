package io.turntabl.tcmsLogger.PubSub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.net.URI;
import java.net.URISyntaxException;

public class RedisConnection {
    public static JedisPool pool() throws URISyntaxException {
        URI redisURI = new URI(System.getenv("REDIS_URL"));
        JedisPoolConfig config = new JedisPoolConfig();

        config.setMaxTotal(10);
        config.setMaxIdle(5);
        config.setMinIdle(1);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        config.setTestWhileIdle(true);
        JedisPool pool = new JedisPool(config, redisURI);
        return pool;
    }
}
