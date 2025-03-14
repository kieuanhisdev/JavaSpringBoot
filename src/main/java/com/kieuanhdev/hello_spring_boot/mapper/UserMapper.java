package com.kieuanhdev.hello_spring_boot.mapper;

import com.kieuanhdev.hello_spring_boot.dto.request.UserControllerRequest;
import com.kieuanhdev.hello_spring_boot.dto.request.UserUpdateRequest;
import com.kieuanhdev.hello_spring_boot.dto.response.UserResponse;
import com.kieuanhdev.hello_spring_boot.entity.User;
import com.kieuanhdev.hello_spring_boot.repository.UserRepository;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserControllerRequest request);
    User updateUser(@MappingTarget User user, UserUpdateRequest request);
    UserResponse toUserRepository(User user);


}
