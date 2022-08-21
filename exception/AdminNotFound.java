package com.bridgelabz.lmsproject.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class AdminNotFound extends RuntimeException{
    private long errorCode;
    private String statusMessage;

    public AdminNotFound(long errorCode, String statusMessage) {
        super(statusMessage);
        this.errorCode = errorCode;
        this.statusMessage = statusMessage;
    }
}
