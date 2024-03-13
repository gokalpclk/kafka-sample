package org.outplay.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.outplay.userservice.model.dto.UserCreateRequestDto;
import org.outplay.userservice.model.entity.User;
import org.outplay.userservice.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gokalp on 13.03.2024
 * @project user-service
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public User create(@RequestBody UserCreateRequestDto userCreateRequestDto) {
        return userService.createUser(userCreateRequestDto);
    }
}
