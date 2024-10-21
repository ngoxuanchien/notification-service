package com.hdbank.consumer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(prefix = "kafka")
public class KafkaProperties {

    @NestedConfigurationProperty
    private KafkaProperty consumerKafka;

    @Bean
    public KafkaProperties.KafkaProperty notificationKafka() {
        return consumerKafka;
    }

    @Data
    public static class KafkaProperty {
        private String bootstrapServers;
        private String securityProtocol;
        private String autoCommit;
        private String autoOffsetReset;

        private String groupId;
        private String topic;
    }

}
