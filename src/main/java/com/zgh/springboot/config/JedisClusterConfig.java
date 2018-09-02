package com.zgh.springboot.config;

import com.zgh.springboot.properties.RedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class JedisClusterConfig {

    @Autowired
    RedisProperties redisProperties;

    @Bean
    public JedisCluster getJedisCluster(){
        String[] nodesIpPort = redisProperties.getNodes().split(",");
        Set<HostAndPort> nodes = new HashSet<>();
        for(String ipPort : nodesIpPort){
            String[] ipPortPair = ipPort.split(":");

            HostAndPort hostAndPort =  new HostAndPort(ipPortPair[0],Integer.parseInt(ipPortPair[1]));
            nodes.add(hostAndPort);

        }
        return new JedisCluster(nodes);
    }
}
