package com.tinylibrary.exception;

public class NameBookNotFound extends RuntimeException {
    public NameBookNotFound(String message) {
        super(message);
    }
}
