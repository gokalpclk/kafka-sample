package org.outplay.userservice.service;

import lombok.RequiredArgsConstructor;
import org.outplay.userservice.config.kafka.producer.KafkaProducer;
import org.outplay.userservice.config.kafka.properties.CustomizedMailTopicProperties;
import org.outplay.userservice.config.kafka.properties.RegisteredUserTopicProperties;
import org.outplay.userservice.model.UserMapper;
import org.outplay.userservice.model.dto.SendMailRequestDto;
import org.outplay.userservice.model.dto.UserCreateRequestDto;
import org.outplay.userservice.model.entity.User;
import org.outplay.userservice.model.payload.RegisteredUserPayload;
import org.outplay.userservice.model.payload.SendMailPayload;
import org.outplay.userservice.repository.UserRepository;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.kafka.support.KafkaHeaders.KEY;
import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

/**
 * @author Gokalp on 13.03.2024
 * @project user-service
 */

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final KafkaProducer kafkaProducer;

    private final RegisteredUserTopicProperties registeredUserTopicProperties;
    private final CustomizedMailTopicProperties customizedMailTopicProperties;

    public User createUser(UserCreateRequestDto userCreateRequestDto) {
        User user = UserMapper.INSTANCE.userCreateRequestDtoToUser(userCreateRequestDto);
        user = userRepository.save(user);

        RegisteredUserPayload payload = RegisteredUserPayload.getUserCreatedPayload(user);
        Map<String, Object> headers = new HashMap<>();
        headers.put(TOPIC, registeredUserTopicProperties.getTopicName());
        headers.put(KEY, user.getId().toString());

        kafkaProducer.sendMessage(new GenericMessage<>(payload, headers));


        return user;
    }

    public void sendMail(SendMailRequestDto sendMailRequestDto) {
        SendMailPayload payload = SendMailPayload.getSendMailPayload(sendMailRequestDto);

        Map<String, Object> headers = new HashMap<>();
        headers.put(TOPIC, customizedMailTopicProperties.getTopicName());
        headers.put(KEY, sendMailRequestDto.getTo());
        kafkaProducer.sendMessage(new GenericMessage<>(payload, headers));
    }
}
