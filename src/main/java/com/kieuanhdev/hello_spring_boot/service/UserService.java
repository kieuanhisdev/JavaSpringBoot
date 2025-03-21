package com.kieuanhdev.hello_spring_boot.service;

import com.kieuanhdev.hello_spring_boot.dto.request.UserControllerRequest;
import com.kieuanhdev.hello_spring_boot.dto.request.UserUpdateRequest;
import com.kieuanhdev.hello_spring_boot.dto.response.UserResponse;
import com.kieuanhdev.hello_spring_boot.entity.User;
import com.kieuanhdev.hello_spring_boot.exception.AppException;
import com.kieuanhdev.hello_spring_boot.exception.ErrorCode;
import com.kieuanhdev.hello_spring_boot.mapper.UserMapper;
import com.kieuanhdev.hello_spring_boot.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;



    public UserResponse createUser(UserControllerRequest request) {
        if(userRepository.existsUserByUsername(request.getUsername())) throw new AppException(ErrorCode.USER_EXISTED);
        User user = userMapper.toUser(request);
        return userMapper.toUserRepository(userRepository.save(user));
    }

    public List<User> getAllUsers() { return userRepository.findAll(); }

    public UserResponse getUserById(String id) {
        return userRepository.getUserById(id);
    }

    public UserResponse updateUser(String id, UserUpdateRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        userMapper.updateUser(user, request);
        return userMapper.toUserRepository(userRepository.save(user));
    }

    public void deleteUser(String userId){

        userRepository.deleteById(userId);
    }

}
