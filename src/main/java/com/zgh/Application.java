package com.zgh;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.spi.AbstractLogger;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;


/**
 * SpringBootApplication
 * @MapperScan(value="com.zgh.springboot.dao") 相当于mapper注解不用写  使用mapScan来扫描mapper接口自动注入
 */

@SpringBootApplication
@ServletComponentScan
public class Application {
    private  static final Logger logger =  LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    /**
     * 为了解决 j'son'x'm'l解析josn为object报错
     * @return
     */
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }
}
