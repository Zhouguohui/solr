package com.zgh.springboot.common;

import com.zgh.springboot.enums.StartKeyEnums;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Component;

/**
 * redis 唯一主键生成
 */
@Component
public class RedisStartId {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private final static String FORMAT = "yyyyMMdd";
    private final static int PADDING_LENGTH = 5;

    public String getMachineGroup(StartKeyEnums startKeys) {
        String key = startKeys+DateTime.now().toString(FORMAT);
       return  key+ String.format("%0" + PADDING_LENGTH + "d", new Object[]{Long.valueOf(getNextId(key, redisTemplate.getConnectionFactory()))});

    }

    private long getNextId(String key, RedisConnectionFactory factory) {
        return (new RedisAtomicLong(key, factory)).incrementAndGet();
    }


}
