package com.example.keycloak_spring.service.user;

import com.example.keycloak_spring.config.KeycloakConfig;
import org.keycloak.admin.client.resource.UsersResource;

public class UserServiceImpel implements UserService{

    @Override
    public UsersResource getInstance() {
        return KeycloakConfig.getInstance().realm(KeycloakConfig.realm).users();
    }
}
