package org.outplay.mailservice.consumers.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Gokalp on 16.03.2024
 * @project kafka-sample
 */
@Configuration
@ConfigurationProperties(prefix = "kafka.topics.user-created")
@Getter
@Setter
public class MailSendConsumerProperties {
    private String topic;
    private String consumerGroup;
}
