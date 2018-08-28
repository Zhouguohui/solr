package com.zgh;

import org.apache.logging.log4j.spi.AbstractLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * SpringBootApplication
 */



@SpringBootApplication
public class Application {
    private  static final Logger logger =  LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        logger.info("111111111111111");

        SpringApplication.run(Application.class, args);
    }
}
