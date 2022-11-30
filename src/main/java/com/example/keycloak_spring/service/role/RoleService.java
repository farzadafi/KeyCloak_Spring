package com.example.keycloak_spring.service.role;

import org.keycloak.admin.client.resource.RolesResource;

public interface RoleService {
    RolesResource getInstance();
}
