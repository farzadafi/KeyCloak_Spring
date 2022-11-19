package com.example.keycloak_spring.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "user_entity")
public class User {
    @Id
    @GeneratedValue(generator = "hibernate_uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(unique = true, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    private String email;

    @Column(nullable = false)
    private boolean email_verified;

    @Column(nullable = false)
    private boolean enabled;

    private String federation_link;

    private String first_name;

    private String last_name;

    private String username;

    private String service_account_client_link;

    @Column(length = 4)
    private Integer not_before;

    private String realm_id;
}
