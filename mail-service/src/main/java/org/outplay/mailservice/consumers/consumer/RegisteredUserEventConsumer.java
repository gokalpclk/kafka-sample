package org.outplay.mailservice.consumers.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.outplay.mailservice.model.dto.SendMailForRegisteredUserEvent;
import org.outplay.mailservice.model.entity.Email;
import org.outplay.mailservice.service.MailService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author Gokalp on 16.03.2024
 * @project kafka-sample
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class RegisteredUserEventConsumer {
    private final MailService mailService;

    @KafkaListener(topics = "${kafka.topics.registered-user.topic}",
            groupId = "${kafka.topics.registered-user.consumerGroup}",
            containerFactory = "concurrentKafkaListenerContainerFactory"
    )
    public void consumeCreatedUserEvent(@Payload SendMailForRegisteredUserEvent eventData,
                                        @Headers ConsumerRecord<String, Object> consumerRecord) {
        log.info("???UserCreatedEventConsumer.consumeApprovalRequestResultedEvent consumed EVENT :{} " +
                        "from partition : {} " +
                        "with offset : {} " +
                        "thread : {} " +
                        "for message key: {}",
                eventData, consumerRecord.partition(), consumerRecord.offset(), Thread.currentThread().getName(), consumerRecord.key());

        Email entity = SendMailForRegisteredUserEvent.getEmailEntityFromEvent(eventData);

        mailService.save(entity);
    }


}
