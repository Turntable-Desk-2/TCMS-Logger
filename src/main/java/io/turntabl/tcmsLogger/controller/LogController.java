package io.turntabl.tcmsLogger.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LogController {
    private static Logger LOGGER = LoggerFactory.getLogger(LogController.class);

    @RequestMapping("/api/logs")
    public String index () {
        LOGGER.trace("Logger needed more information.");
        LOGGER.debug("Logger needed to debug.");
        LOGGER.info("Logger took input.");
        LOGGER.warn("logger needed to warn.");
        LOGGER.error("logger encountered an error with value.");

        return "Welcome to Spring Logging! Check the console to see the log messages";

    }
}
