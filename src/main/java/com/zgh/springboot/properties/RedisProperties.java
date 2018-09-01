package com.zgh.springboot.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
//@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {

    @Value("${spring.redis.cluster.nodes}")
    private String clusterNodes;

}
