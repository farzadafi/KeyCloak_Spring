package com.example.keycloak_spring.controller;

import com.example.keycloak_spring.dto.UserDto;
import com.example.keycloak_spring.service.user.UserServiceImpel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpel userService;

    public UserController(UserServiceImpel userServiceImpel) {
        this.userService = userServiceImpel;
    }

    @PostMapping("/registerUser")
    public String registerUser(@Valid @RequestBody UserDto userDto) {
        userService.registerUser(userDto);
        return "OK";
    }
}
