package com.tinylibrary.exception;

import java.time.LocalDateTime;

public class apiError {
    private LocalDateTime timeStamp;
    private int status;
    private String error;
    private String message;
    private String path;

    public apiError(int status, String error, String message, String path){
        this.timeStamp =LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }

    public String getMessage() {
        return message;
    }
}
