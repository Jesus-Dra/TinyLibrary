package com.tinylibrary.exception;

public class BorrowAlreadyReturnException extends RuntimeException {
    public BorrowAlreadyReturnException(String message) {
        super(message);
    }
}
