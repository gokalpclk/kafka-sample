package org.outplay.userservice.model.dto;

import lombok.Data;

/**
 * @author Gokalp on 17.03.2024
 * @project kafka-sample
 */
@Data
public class SendMailRequestDto {
    private String to;
    private String subject;
    private String body;
}
