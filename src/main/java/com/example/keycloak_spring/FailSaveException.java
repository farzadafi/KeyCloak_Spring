package com.example.keycloak_spring;

public class FailSaveException extends RuntimeException {

    public FailSaveException(String message) {
        super(message);
    }
}
