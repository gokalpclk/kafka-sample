package org.outplay.userservice.model.dto;

/**
 * @author Gokalp on 13.03.2024
 * @project user-service
 */
public record UserCreateRequestDto(String firstName, String lastName, String email) {
}
