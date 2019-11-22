package io.turntabl.tcmsLogger.PubSub;

import redis.clients.jedis.Jedis;

import java.net.URISyntaxException;
import java.time.LocalDateTime;

public class Publisher {
    public static void publish(String message){
        try (
                Jedis jedis = RedisConnection.pool().getResource()){
            jedis.publish("customers", LocalDateTime.now().toString() + " : " + message);
            jedis.ping();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

}
