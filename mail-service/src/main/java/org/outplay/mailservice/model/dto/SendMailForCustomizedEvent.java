package org.outplay.mailservice.model.dto;

import lombok.Builder;
import lombok.Data;
import org.outplay.mailservice.model.entity.Email;

/**
 * @author Gokalp on 17.03.2024
 * @project kafka-sample
 */
@Data
@Builder
public class SendMailForCustomizedEvent {
    private String to;
    private String subject;
    private String body;

    public static Email getEmailEntityFromEvent(SendMailForCustomizedEvent event) {
        return Email.builder()
                .to(event.getTo())
                .subject(event.getSubject())
                .body(event.getBody())
                .build();
    }
}
