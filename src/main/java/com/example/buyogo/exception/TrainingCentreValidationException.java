package com.example.buyogo.exception;

public class TrainingCentreValidationException extends RuntimeException {

    public TrainingCentreValidationException(String message) {
        super(message);
    }

    public TrainingCentreValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}