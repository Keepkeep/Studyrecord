package untils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "test")
public class RedisPropertis {
    private String springRedisIp;
    private String  springPort;
}
