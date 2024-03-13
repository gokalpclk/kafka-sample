package org.outplay.userservice.service;

import lombok.RequiredArgsConstructor;
import org.outplay.userservice.config.kafka.producer.KafkaProducer;
import org.outplay.userservice.config.kafka.properties.UserCreatedTopicProperties;
import org.outplay.userservice.model.UserMapper;
import org.outplay.userservice.model.dto.UserCreateRequestDto;
import org.outplay.userservice.model.dto.UserCreatedPayload;
import org.outplay.userservice.model.entity.User;
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

    private final UserCreatedTopicProperties userCreatedTopicProperties;

    public User createUser(UserCreateRequestDto userCreateRequestDto) {
        User user = UserMapper.INSTANCE.userCreateRequestDtoToUser(userCreateRequestDto);
        user = userRepository.save(user);

        UserCreatedPayload payload = UserCreatedPayload.GetUserCreatedPayload(user);

        Map<String, Object> headers = new HashMap<>();
        headers.put(TOPIC, userCreatedTopicProperties.getTopicName());
        headers.put(KEY, user.getId().toString());

        kafkaProducer.sendMessage(new GenericMessage<>(payload, headers));


        return user;
    }
}
