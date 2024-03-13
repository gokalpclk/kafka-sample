package org.outplay.userservice.config.kafka.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Gokalp on 13.03.2024
 * @project user-service
 */
@Configuration
@ConfigurationProperties(prefix = "kafka.topics.user-created")
@Getter
@Setter
public class UserCreatedTopicProperties {
    private String topicName;
    private int partitionCount;
    private short replicationFactor;
    private String retentionInMs;
}
