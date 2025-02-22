package com.placementmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

	@ControllerAdvice
	public class GlobalExceptionHandler {

	    // Handling PlacementServiceException
	    @ExceptionHandler(PlacementServiceException.class)
	    public ResponseEntity<String> handlePlacementServiceException(PlacementServiceException ex) {
	        // Log the exception for debugging
	        System.err.println("PlacementServiceException: " + ex.getMessage());
	        
	        // Return a response with 400 Bad Request and the exception message
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	    }

	    // Handling CollegeServiceException
	    @ExceptionHandler(CollegeServiceException.class)
	    public ResponseEntity<String> handleCollegeServiceException(CollegeServiceException ex) {
	        // Log the exception for debugging
	        System.err.println("CollegeServiceException: " + ex.getMessage());
	        
	        // Return a response with 400 Bad Request and the exception message
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	    }

	    // Handling AdminServiceException
	    @ExceptionHandler(AdminServiceException.class)
	    public ResponseEntity<String> handleAdminServiceException(AdminServiceException ex) {
	        // Log the exception for debugging
	        System.err.println("AdminServiceException: " + ex.getMessage());
	        
	        // Return a response with 400 Bad Request and the exception message
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	    }

	    // Handling UserServiceException
	    @ExceptionHandler(UserServiceException.class)
	    public ResponseEntity<String> handleUserServiceException(UserServiceException ex) {
	        // Log the exception for debugging
	        System.err.println("UserServiceException: " + ex.getMessage());
	        
	        // Return a response with 400 Bad Request and the exception message
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	    }

	    // Handling CertificateServiceException
	   // @ExceptionHandler(CertificateServiceException.class)
	    public ResponseEntity<String> handleCertificateServiceException(CertificateServiceException ex) {
	        // Log the exception for debugging
	        System.err.println("CertificateServiceException: " + ex.getMessage());
	        
	        // Return a response with 400 Bad Request and the exception message
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	    }

	    // Handling any generic exceptions
	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<String> handleGenericException(Exception ex) {
	        // Log the exception for debugging
	        System.err.println("GenericException: " + ex.getMessage());
	        
	        // Return a response with 500 Internal Server Error and a generic error message
	        return new ResponseEntity<>("An unexpected error occurred. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	    // Handling MethodArgumentNotValidException for validation errors
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
	        // Collect validation error messages
	        StringBuilder errors = new StringBuilder();
	        ex.getBindingResult().getAllErrors().forEach(error -> errors.append(error.getDefaultMessage()).append("; "));
	        
	        // Return validation error messages with 400 Bad Request
	        return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
	    }
	}



