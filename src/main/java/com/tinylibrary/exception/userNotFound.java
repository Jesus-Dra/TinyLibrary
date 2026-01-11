package com.tinylibrary.exception;

public class userNotFound extends RuntimeException {
    public userNotFound(String message) {
        super(message);
    }
}
