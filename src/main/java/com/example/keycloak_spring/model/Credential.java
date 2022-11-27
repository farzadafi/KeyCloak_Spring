package com.example.keycloak_spring.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.OffsetDateTime;
import java.util.UUID;

public class Credential {

    @Id
    @GeneratedValue(generator = "hibernate_uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(unique = true,nullable = false, columnDefinition = "VARCHAR(36)")
    private UUID id;

    private byte[] salt;

    private String type;

    @OneToOne
    private User user;

    @CreationTimestamp
    private OffsetDateTime creationDate;

    private String user_label;

    private String secret_data;

    private String credential_data;

    private int priority;
}
