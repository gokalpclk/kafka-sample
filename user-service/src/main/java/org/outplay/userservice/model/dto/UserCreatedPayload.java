package org.outplay.userservice.model.dto;

import lombok.Builder;
import lombok.Data;
import org.outplay.userservice.model.entity.User;

import java.util.Date;
import java.util.UUID;

/**
 * @author Gokalp on 13.03.2024
 * @project user-service
 */
@Data
@Builder
public class UserCreatedPayload {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean status;

    public static UserCreatedPayload GetUserCreatedPayload(User user) {
        return UserCreatedPayload.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }
}
