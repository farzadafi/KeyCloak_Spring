package com.example.keycloak_spring.repository;

import com.example.keycloak_spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findUserByUsername(String username);
}
