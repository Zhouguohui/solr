package com.zgh;

import org.apache.logging.log4j.spi.AbstractLogger;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * SpringBootApplication
 * @MapperScan(value="com.zgh.springboot.dao") 相当于mapper注解不用写  使用mapScan来扫描mapper接口自动注入
 */

@SpringBootApplication
public class Application {
    private  static final Logger logger =  LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        logger.info("111111111111111");

        SpringApplication.run(Application.class, args);
    }
}
