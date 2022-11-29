package com.example.keycloak_spring.service.user;

import com.example.keycloak_spring.exception.FailSaveException;
import com.example.keycloak_spring.config.KeycloakConfig;
import com.example.keycloak_spring.dto.UserDto;
import com.example.keycloak_spring.model.Credential;
import com.example.keycloak_spring.model.User;
import com.example.keycloak_spring.repository.UserRepository;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpel implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UsersResource getInstance() {
        return KeycloakConfig.getInstance().realm(KeycloakConfig.REALM).users();
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

    @Override
    public void registerUser(UserDto userDto) {
        UserRepresentation user = createUserRepresentation(userDto);
        UsersResource instance = getInstance();
        Response response = instance.create(user);
        if(response.getStatus() != 200 && response.getStatus() != 201)
            throw new FailSaveException("save isn't successful");
    }

    public void registerUserWithUserRole(UserDto userDto) {
        UserRepresentation user = createUserRepresentation(userDto);
        Keycloak instance = KeycloakConfig.getInstance();
        UsersResource usersResource = instance.realm(KeycloakConfig.getRealmName()).users();
        var response = usersResource.create(user);
        response.close();

        User findUser = userRepository.findUserByUsername(userDto.getUsername());
        RoleRepresentation realmRole = instance.realm(KeycloakConfig.getRealmName()).roles()
                .get("user").toRepresentation(); //name of role is here!

        System.out.println("under");
        UserResource userResource = usersResource.get(findUser.getId().toString()); //userId is here
        userResource.roles().realmLevel()
                .add(List.of(realmRole));
    }
}
