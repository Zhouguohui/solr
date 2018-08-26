package com.zgh.springboot.entity;


import lombok.Data;
import lombok.ToString;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


/**
 *属性配置 两种方法
 * 1 ConfigurationProperties来通过前缀匹配来实现 属性注入   默认冲全局配置文件中获取数据
 * 2 使用@Value 是spring的注解
 *   1:使用@Value("${user.age}")
 *   2:使用正则 @Value("#{10*10}")
 *   3:使用布尔表达式 @Value("true")
 *
 *
 *   两则的区别
 *   1 ConfigurationProperties 批量的注入  支持list、map等复杂类型的注入
 *     支持语法的驼峰 支持JSR303数据校验
 *   2 Value 需要一个个制定   支持正则运算
 *
 *
 *   加载指定的配置文件 来注入
 *   @PropertySource(value={"classpath:user.properties"})
 */
@Data
@Component
//@ConfigurationProperties(prefix = "user")
@PropertySource(value={"classpath:user.properties"})
@ToString
public class User{

    private Integer age;

    private String names;

    private List<String> l;

    private Map<String,String> m;


}
