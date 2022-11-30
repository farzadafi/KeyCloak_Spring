package com.example.keycloak_spring.service.role;

import com.example.keycloak_spring.config.KeycloakConfig;
import org.keycloak.admin.client.resource.RolesResource;

public class RoleServiceImpel implements RoleService{

    @Override
    public RolesResource getInstance() {
        return KeycloakConfig.getInstance().realm(KeycloakConfig.REALM).roles();
    }
}
