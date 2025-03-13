package com.kieuanhdev.hello_spring_boot.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringControler {
    @GetMapping("/hello")
    public String hello(){
        return "Hello Spring Boot";
    }
}
