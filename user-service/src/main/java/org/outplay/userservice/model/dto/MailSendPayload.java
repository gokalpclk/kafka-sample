package org.outplay.userservice.model.dto;

import lombok.Builder;
import lombok.Data;
import org.outplay.userservice.model.entity.User;

import java.util.UUID;

/**
 * @author Gokalp on 13.03.2024
 * @project user-service
 */
@Data
@Builder
public class MailSendPayload {

    private UUID id;
    private String email;
    private String subject;
    private String message;
    private Boolean status;

    public static MailSendPayload GetUserCreatedPayload(User user) {
        return MailSendPayload.builder()
                .id(user.getId())
                .email(user.getEmail())
                .subject("Welcome to Outplay")
                .message("Welcome to Outplay, " + user.getFirstName() + " " + user.getLastName() + "!")
                .build();
    }
}
