package com.java_tbt.api.core.exceptions;

public class AppointmentValidationException extends RuntimeException {

    public AppointmentValidationException(String errorMessage) {
        super(errorMessage);
    }

}
