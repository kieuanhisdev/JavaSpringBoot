package com.kieuanhdev.hello_spring_boot.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserControllerRequest {

    @Size(min = 3, max = 50, message = "USERNAME_INVALID")
    String username;

    @Size(min = 8, max = 50, message = "INVALID_PASSWORD")
    String password;

    String firsname;

    String lastname;

    LocalDate dob;



}
