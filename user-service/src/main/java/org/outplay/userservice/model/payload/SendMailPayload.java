package org.outplay.userservice.model.payload;

import lombok.Builder;
import lombok.Data;
import org.outplay.userservice.model.dto.SendMailRequestDto;

/**
 * @author Gokalp on 17.03.2024
 * @project kafka-sample
 */
@Data
@Builder
public class SendMailPayload {
    private String to;
    private String subject;
    private String body;

    public static SendMailPayload getSendMailPayload(SendMailRequestDto sendMailRequestDto) {
        return SendMailPayload.builder()
                .to(sendMailRequestDto.getTo())
                .subject(sendMailRequestDto.getSubject())
                .body(sendMailRequestDto.getBody())
                .build();
    }
}
