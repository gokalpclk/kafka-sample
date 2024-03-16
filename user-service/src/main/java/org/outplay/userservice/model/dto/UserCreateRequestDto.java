package org.outplay.userservice.model.dto;

import lombok.Data;

/**
 * @author Gokalp on 13.03.2024
 * @project user-service
 */
@Data
public class UserCreateRequestDto {
    private String firstName;
    private String lastName;
    private String email;
}
