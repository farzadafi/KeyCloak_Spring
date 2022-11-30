package com.example.keycloak_spring.service.role;

import com.example.keycloak_spring.dto.RoleDto;
import org.keycloak.admin.client.resource.RolesResource;

public interface RoleService {
    RolesResource getInstance();

    void addRole(RoleDto roleDto);
}
