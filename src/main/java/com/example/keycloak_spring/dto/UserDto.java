package com.example.keycloak_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {

    private String id;

    private String firstname;

    private String lastname;

    private String username;

    private String email;

    private String meliCode;
}
