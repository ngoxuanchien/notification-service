package com.hdbank.cache.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
@ConfigurationProperties(prefix = "spring.app.redis")
public class RedisAppProperties {

    private long defaultExpiredTimeInSecond;

    private long defaultPollingDuration;
    private long defaultPollingInterval;
}
