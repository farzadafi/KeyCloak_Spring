package com.example.keycloak_spring.service.user;

import org.keycloak.admin.client.resource.UsersResource;

public interface UserService {
    UsersResource getInstance();
}
