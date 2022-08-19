package com.bridgelabz.lmsproject.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
    private String errorMsg;
    private long errorCode;
    private Object token;
}
