package com.bridgelabz.lmsproject.exception;

import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * purpose:creating custom mentor not found exception
 * @author Anuj Solanki
 */
@ResponseStatus
public class MentorNotFound extends RuntimeException{
    private long errorCode;
    private String statusMessage;

    public MentorNotFound(long errorCode, String statusMessage) {
        super(statusMessage);
        this.errorCode = errorCode;
        this.statusMessage = statusMessage;
    }
}
