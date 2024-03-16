package org.outplay.mailservice.model.dto;

import lombok.*;
import org.outplay.mailservice.model.entity.Email;

import java.util.UUID;

/**
 * @author Gokalp on 16.03.2024
 * @project kafka-sample
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MailSendEvent {
    private UUID id;
    private String email;
    private String subject;
    private String message;

    public static Email getAddressEntityFromEvent(MailSendEvent event) {
        return Email.builder()
                .userId(event.getId())
                .email(event.getEmail())
                .subject(event.getSubject())
                .message(event.getMessage())
                .build();
    }
}
