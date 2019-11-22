package io.turntabl.tcmsLogger.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

public class LogController {
    public static String index () {
        Logger LOGGER = LoggerFactory.getLogger(LogController.class);

        LOGGER.trace("Logger needed more information.");
        LOGGER.debug("Logger needed to debug.");
        LOGGER.info("Logger took input.");
        LOGGER.warn("logger needed to warn.");
        LOGGER.error("logger encountered an error with value.");
        return "Welcome to Spring Logging! Check the console to see the log messages";
    }

}
