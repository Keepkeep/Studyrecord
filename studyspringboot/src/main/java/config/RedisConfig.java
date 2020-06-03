package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import server.Redis;
import untils.RedisPropertis;


@Configuration
@EnableConfigurationProperties(RedisPropertis.class)
public class RedisConfig {

    @Autowired
    private  RedisPropertis redisPropertis;

    @Bean
    public Redis  redis(){
        Redis redis = new Redis();
        redis.setSpringRedisIp(redisPropertis.getSpringRedisIp());
        redis.setSpringPort(redisPropertis.getSpringPort());
        return  redis;
    }
}
