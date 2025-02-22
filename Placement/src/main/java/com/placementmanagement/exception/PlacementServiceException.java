package com.placementmanagement.exception;

public class PlacementServiceException extends RuntimeException {

    // Constructor with custom message
    public PlacementServiceException(String message) {
        super(message);
    }

    // Constructor with custom message and cause
    public PlacementServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}


