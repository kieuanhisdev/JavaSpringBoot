package com.kieuanhdev.hello_spring_boot.Controller;

import com.kieuanhdev.hello_spring_boot.dto.request.UserControllerRequest;
import com.kieuanhdev.hello_spring_boot.dto.request.UserUpdateRequest;
import com.kieuanhdev.hello_spring_boot.entity.User;
import com.kieuanhdev.hello_spring_boot.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    User createUser(@RequestBody UserControllerRequest request) {

        return userService.createUser(request);
    }

    @GetMapping
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    User updateUser(@PathVariable String id, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(id, request);
    }

    @DeleteMapping("/{id}")
    String deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return "deleted successfully";
    }

}
