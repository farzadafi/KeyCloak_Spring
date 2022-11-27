package com.example.keycloak_spring.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

public class UserAttribute {
    @Id
    @GeneratedValue(generator = "hibernate_uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(unique = true,nullable = false, columnDefinition = "VARCHAR(36)")
    private UUID id;

    @Column(nullable = false)
    private String name;

    private String value;

    @JoinColumn(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
