package com.bridgelabz.lmsproject.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class CandidateNotFound extends RuntimeException{
    private long errorCode;
    private String statusMessage;

    public CandidateNotFound(long errorCode, String statusMessage) {
        this.errorCode = errorCode;
        this.statusMessage = statusMessage;
    }
}
