package com.placementmanagement.exception;

public class UserServiceException extends RuntimeException {

    // Constructor with custom message
    public UserServiceException(String message) {
        super(message);
    }

    // Constructor with custom message and cause
    public UserServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}