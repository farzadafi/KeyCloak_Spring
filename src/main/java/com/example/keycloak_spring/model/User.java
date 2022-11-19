package com.example.keycloak_spring.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.keycloak.KeycloakSecurityContext;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "user_entity")
public class User extends KeycloakSecurityContext implements UserDetails {
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }
}
