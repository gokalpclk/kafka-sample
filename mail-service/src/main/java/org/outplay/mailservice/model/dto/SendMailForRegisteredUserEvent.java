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
public class SendMailForRegisteredUserEvent {
    private UUID id;
    private String to;

    public static Email getEmailEntityFromEvent(SendMailForRegisteredUserEvent event) {
        return Email.builder()
                .userId(event.getId())
                .to(event.getTo())
                .build();
    }
}
