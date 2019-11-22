package io.turntabl.tcmsLogger;


import io.turntabl.tcmsLogger.PubSub.Subscriber;
import io.turntabl.tcmsLogger.controller.LogController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URISyntaxException;

@SpringBootApplication
public class TcmsLoggerApplication {
	public static void main(String[] args) throws URISyntaxException {
		SpringApplication.run(TcmsLoggerApplication.class, args);
		Subscriber.onMessage();
	}

}