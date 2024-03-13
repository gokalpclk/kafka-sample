package org.outplay.userservice.model;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.outplay.userservice.model.dto.UserCreateRequestDto;
import org.outplay.userservice.model.entity.User;

/**
 * @author Gokalp on 13.03.2024
 * @project user-service
 */

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userCreateRequestDtoToUser(UserCreateRequestDto userCreateRequestDto);

}
