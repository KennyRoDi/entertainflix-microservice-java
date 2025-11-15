package com.example.microservice.application.exception;

public class DecisionException extends RuntimeException {

    public DecisionException(String message) {
        super(message);
    }

    public DecisionException(String message, Throwable cause) {
        super(message, cause);
    }
}
