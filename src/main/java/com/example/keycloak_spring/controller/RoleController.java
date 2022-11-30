package com.example.keycloak_spring.controller;

import com.example.keycloak_spring.dto.RoleDto;
import com.example.keycloak_spring.service.role.RoleServiceImpel;
import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getAllRole")
    public List<RoleRepresentation> getAllRole() {
        return roleService.getAllRole();
    }
}
