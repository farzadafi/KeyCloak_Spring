package com.example.keycloak_spring.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoleDto {

    private String name;
    private String description;
}
