package com.example.keycloak_spring.service.user;

import com.example.keycloak_spring.dto.UserDto;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;

public interface UserService {
    UsersResource getInstance();

    UserRepresentation createUserRepresentation(UserDto userDto);

    void registerUser(UserDto userDto);

    void registerUserWithUserRole(UserDto userDto);

    void removeUser(String username);
}
