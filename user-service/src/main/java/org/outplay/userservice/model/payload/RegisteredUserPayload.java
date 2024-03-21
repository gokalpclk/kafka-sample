package org.outplay.userservice.model.payload;

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
public class RegisteredUserPayload {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;

    public static RegisteredUserPayload getUserCreatedPayload(User user) {
        return RegisteredUserPayload.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }
}
