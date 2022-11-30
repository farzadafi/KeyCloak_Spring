package com.example.keycloak_spring.service.role;

import com.example.keycloak_spring.dto.RoleDto;
import org.keycloak.admin.client.resource.RolesResource;
import org.keycloak.representations.idm.RoleRepresentation;

import java.util.List;

public interface RoleService {
    RolesResource getInstance();

    void addRole(RoleDto roleDto);

    List<RoleRepresentation> getAllRole();

    void removeRoles(String roleName);
    }
