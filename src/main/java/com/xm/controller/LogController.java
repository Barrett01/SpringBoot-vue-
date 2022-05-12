package com.xm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
    private Logger logger = LoggerFactory.getLogger(LogController.class);

    @GetMapping("/log")
    public String testLog(){
        logger.debug("test debug");
        logger.info("test info");
        logger.warn("test warn");
        logger.error("test error");
        return "log api test";
    }
}
