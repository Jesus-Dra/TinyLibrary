package com.tinylibrary.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(userNotFound.class)
    public ResponseEntity<apiError> handleUserNotFound(userNotFound ex, HttpServletRequest request){
        apiError error = new apiError(HttpStatus.NOT_FOUND.
                value(), "Not Found", ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(NameBookNotFound.class)
    public ResponseEntity<apiError> handleBookNotFound(NameBookNotFound ex, HttpServletRequest request){
        apiError error = new apiError(HttpStatus.NOT_FOUND.
                value(), "Libro no encontrado", ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(CorreoAlreadyExistException.class)
    public  ResponseEntity<apiError> handleCorreoNotFound(CorreoAlreadyExistException ex, HttpServletRequest request){
        apiError error = new apiError(HttpStatus.CONFLICT.
                value(),"Correo ya registrado", ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(NameAlreadyExistException.class)
    public  ResponseEntity<apiError> handleNameAlready(NameAlreadyExistException ex, HttpServletRequest request){
        apiError error = new apiError(HttpStatus.CONFLICT.
                value(),"El nombre de este libro ya esta registrado", ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
}
