package org.outplay.userservice.config.kafka.producer;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;


/**
 * @author Gokalp on 13.03.2024
 * @project user-service
 */

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(GenericMessage message) {
        final CompletableFuture<SendResult<String, Object>> completableResult = kafkaTemplate.send(message);

        completableResult.whenComplete((result, ex) -> {
            if (ex != null) {
                log.error("Unable to deliver message to Kafka", ex);
            } else {
                if (result == null) {
                    log.info("Empty result on success for message {}", message);
                    return;
                }
                log.info("Message: {} published, topic: {}, partition: {} and offset: {}",
                        message.getPayload(),
                        result.getRecordMetadata().topic(),
                        result.getRecordMetadata().partition(),
                        result.getRecordMetadata().offset());
            }
        });

    }
}
