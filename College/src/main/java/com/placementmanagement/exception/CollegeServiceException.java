package com.placementmanagement.exception;

public class CollegeServiceException extends RuntimeException {

    // Constructor with custom message
    public CollegeServiceException(String message) {
        super(message);
    }

    // Constructor with custom message and cause
    public CollegeServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
