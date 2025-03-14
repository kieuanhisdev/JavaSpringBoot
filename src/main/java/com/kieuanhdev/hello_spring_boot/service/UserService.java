package com.kieuanhdev.hello_spring_boot.service;

import com.kieuanhdev.hello_spring_boot.dto.request.UserControllerRequest;
import com.kieuanhdev.hello_spring_boot.dto.request.UserUpdateRequest;
import com.kieuanhdev.hello_spring_boot.entity.User;
import com.kieuanhdev.hello_spring_boot.exception.AppException;
import com.kieuanhdev.hello_spring_boot.exception.ErrorCode;
import com.kieuanhdev.hello_spring_boot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserControllerRequest request) {
        if(userRepository.existsUserByUsername(request.getUsername())) throw new AppException(ErrorCode.USER_EXISTED);
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirsname(request.getFirsname());
        user.setLastname(request.getLastname());
        user.setDob(request.getDob());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() { return userRepository.findAll(); }

    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(String id, UserUpdateRequest request) {
        User user = getUserById(id);
        user.setPassword(request.getPassword());
        user.setFirsname(request.getFirsname());
        user.setLastname(request.getLastname());
        user.setDob(request.getDob());
        return userRepository.save(user);
    }

    public void deleteUser(String userId){

        userRepository.deleteById(userId);
    }

}
