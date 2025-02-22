package com.placementmanagement.exception;

public class CertificateServiceException extends RuntimeException {

    // Constructor with custom message
    public CertificateServiceException(String message) {
        super(message);
    }

    // Constructor with custom message and cause
    public CertificateServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
