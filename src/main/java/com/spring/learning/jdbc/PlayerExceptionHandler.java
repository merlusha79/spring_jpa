package com.spring.learning.jdbc;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class PlayerExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<PlayerErrorResponse> playerNotFoundHandler (PlayerNotFoundException ex, HttpServletRequest req){

        PlayerErrorResponse error = new PlayerErrorResponse(
                ZonedDateTime.now(),
                NOT_FOUND.value(),
                req.getRequestURI(),
                ex.getMessage());

        return new ResponseEntity<> (error, NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<PlayerErrorResponse> genericHandler (Exception ex, HttpServletRequest req){
        PlayerErrorResponse error = new PlayerErrorResponse(
                ZonedDateTime.now(),
                BAD_REQUEST.value(),
                req.getRequestURI(),
                ex.getMessage());

        return new ResponseEntity<> (error, BAD_REQUEST);
    }
}
