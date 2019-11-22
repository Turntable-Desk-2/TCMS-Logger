package io.turntabl.tcmsLogger.PubSub;

import io.turntabl.tcmsLogger.TcmsLoggerApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import java.net.URISyntaxException;

public class Subscriber {
    public static final Logger logger = LoggerFactory.getLogger(TcmsLoggerApplication.class);

    public static void onMessage() throws URISyntaxException {
        Jedis jSubscriber = RedisConnection.pool().getResource();

        jSubscriber.subscribe(new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {

                if (channel.equals("customers")) {
                    customers_topic(channel, message);
                } else if (channel.equals("projects")) {
                    customers_topic(channel, message);
                } else {
                    logger.warn("Invalid topic: " + channel);
                }
            }
        }, "customers", "projects");
    }

        private static void customers_topic(String channel, String message) {
            if (message.trim().endsWith("[UPDATE") ||
                    message.trim().endsWith("[ACCESS")){
                logger.info(channel + " : " + message );
            }
            else  if (message.trim().endsWith("[ERROR")){
                logger.error(channel + " : " + message );
            }
            else {
                logger.warn(message);
            }
        }

}
