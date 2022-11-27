package com.example.keycloak_spring.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;
import java.util.UUID;

public class Role {
    @Id
    @GeneratedValue(generator = "hibernate_uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(unique = true,nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    private String name;

    private String realm_id;

    @ManyToMany
    private Set<User> users;
}
