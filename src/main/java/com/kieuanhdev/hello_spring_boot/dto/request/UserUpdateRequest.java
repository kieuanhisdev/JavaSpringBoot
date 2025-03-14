package com.kieuanhdev.hello_spring_boot.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {

     String password;
     String firsname;
     String lastname;
     LocalDate dob;


}
