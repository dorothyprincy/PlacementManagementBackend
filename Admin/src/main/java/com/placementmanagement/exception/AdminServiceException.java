package com.placementmanagement.exception;

public class AdminServiceException extends RuntimeException {

    // Constructor with custom message
    public AdminServiceException(String message) {
        super(message);
    }

    // Constructor with custom message and cause
    public AdminServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}


