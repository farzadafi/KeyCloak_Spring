package com.example.keycloak_spring.exception;

public class FailSaveException extends RuntimeException {

    public FailSaveException(String message) {
        super(message);
    }
}
