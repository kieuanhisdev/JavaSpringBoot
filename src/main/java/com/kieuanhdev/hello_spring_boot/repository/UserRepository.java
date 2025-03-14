package com.kieuanhdev.hello_spring_boot.repository;

import com.kieuanhdev.hello_spring_boot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    boolean existsUserByUsername(String id);
}
