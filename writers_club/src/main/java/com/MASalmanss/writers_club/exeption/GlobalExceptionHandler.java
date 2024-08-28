package com.MASalmanss.writers_club.exeption;

import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<String> handleUnAuthorized(AuthenticationException ex){
        var message = "No !";
        return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(message);
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<String> handlePermitException(AccessDeniedException ex){
        var message = "No !";
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(message);
    }
}
