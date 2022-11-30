package com.example.keycloak_spring.service.role;

import com.example.keycloak_spring.config.KeycloakConfig;
import com.example.keycloak_spring.dto.RoleDto;
import org.keycloak.admin.client.resource.RolesResource;
import org.keycloak.representations.idm.RoleRepresentation;

import java.util.List;

public class RoleServiceImpel implements RoleService{

    @Override
    public RolesResource getInstance() {
        return KeycloakConfig.getInstance().realm(KeycloakConfig.REALM).roles();
    }

    @Override
    public void addRole(RoleDto roleDto) {
        RolesResource rolesResource = getInstance();

        RoleRepresentation roleRepresentation = new RoleRepresentation(roleDto.getName(),
                roleDto.getDescription(),
                true);
        rolesResource.create(roleRepresentation);
    }

    @Override
    public List<RoleRepresentation> getAllRole() {
        RolesResource rolesResource = getInstance();

        return rolesResource.list();
    }

    @Override
    public void removeRoles(String roleName) {
        RolesResource instance = getInstance();
        instance.deleteRole(roleName);
    }
}
