package com.example.keycloak_spring.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(FailSaveException.class)
    public ResponseEntity<String> failSaveExceptionHandler(FailSaveException u) {
        log.error(u.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(u.getMessage());
    }
}
