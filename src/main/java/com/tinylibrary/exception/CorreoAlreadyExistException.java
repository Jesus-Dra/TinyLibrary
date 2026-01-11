package com.tinylibrary.exception;

public class CorreoAlreadyExistException extends RuntimeException {
    public CorreoAlreadyExistException(String message) {
        super(message);
    }
}
