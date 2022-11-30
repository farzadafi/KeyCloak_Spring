package com.example.keycloak_spring.controller;

import com.example.keycloak_spring.dto.RoleDto;
import com.example.keycloak_spring.service.role.RoleServiceImpel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

    private final RoleServiceImpel roleService;

    public RoleController(RoleServiceImpel roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/addRole")
    public String addRole(@RequestBody RoleDto roleDto) {
        roleService.addRole(roleDto);
        return "OK";
    }
}
