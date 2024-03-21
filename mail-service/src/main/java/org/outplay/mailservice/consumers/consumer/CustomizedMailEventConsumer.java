package org.outplay.mailservice.consumers.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.outplay.mailservice.model.dto.SendMailForCustomizedEvent;
import org.outplay.mailservice.model.entity.Email;
import org.outplay.mailservice.service.MailService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author Gokalp on 17.03.2024
 * @project kafka-sample
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class CustomizedMailEventConsumer {
    private final MailService mailService;

    @KafkaListener(topics = "${kafka.topics.customized-mail.topic}",
            groupId = "${kafka.topics.customized-mail.consumerGroup}",
            containerFactory = "concurrentKafkaListenerContainerFactory"
    )
    public void consumeCustomizedMailEvent(@Payload SendMailForCustomizedEvent eventData,
                                           @Headers ConsumerRecord<String, Object> consumerRecord) {
        log.info("___UserCreatedEventConsumer.consumeApprovalRequestResultedEvent consumed EVENT :{} " +
                        "from partition : {} " +
                        "with offset : {} " +
                        "thread : {} " +
                        "for message key: {}",
                eventData, consumerRecord.partition(), consumerRecord.offset(), Thread.currentThread().getName(), consumerRecord.key());

        Email entity = SendMailForCustomizedEvent.getEmailEntityFromEvent(eventData);

        mailService.save(entity);
    }
}
