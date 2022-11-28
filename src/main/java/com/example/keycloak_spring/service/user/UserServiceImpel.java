package com.example.keycloak_spring.service.user;

import com.example.keycloak_spring.config.KeycloakConfig;
import com.example.keycloak_spring.dto.UserDto;
import com.example.keycloak_spring.model.Credential;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

import java.util.Collections;

public class UserServiceImpel implements UserService{

    @Override
    public UsersResource getInstance() {
        return KeycloakConfig.getInstance().realm(KeycloakConfig.realm).users();
    }

    @Override
    public UserRepresentation createUserRepresentation(UserDto userDto) {
        CredentialRepresentation credential = Credential
                .createPasswordCredentials(userDto.getPassword());
        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setUsername(userDto.getUsername());
        userRepresentation.setFirstName(userDto.getFirstname());
        userRepresentation.setLastName(userDto.getLastname());
        userRepresentation.setEmail(userDto.getEmail());
        userRepresentation.setCredentials(Collections.singletonList(credential));
        userRepresentation.setEnabled(true);

        userRepresentation.singleAttribute("meliCode", userDto.getMeliCode());
        return userRepresentation;
    }
}
