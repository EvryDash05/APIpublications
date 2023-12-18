package com.project.publications.dto.mapper;

import com.project.publications.dto.UserDTO;
import com.project.publications.models.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mappings({
            @Mapping(target = "userId", source = "userId"),
            @Mapping(target = "userName", source = "userName"),
            @Mapping(target = "userAge", source = "userAge"),
            @Mapping(target = "email", source = "email"),
            @Mapping(target = "password", ignore = true)
    })
    UserDTO toUserDto(User user);

    @InheritInverseConfiguration
    User toEntityUser(UserDTO userDto);

    List<UserDTO> toUsersDto(List<User> userList);

    List<User> toUserEntity(List<UserDTO> userList);

}
