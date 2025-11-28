package com.java_tbt.api.infra.exceptions;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.java_tbt.api.core.exceptions.AppointmentValidationException;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class HttpExceptionHandler {

    protected record ValidationExceptionData(
            String field,
            String error) {
        public ValidationExceptionData(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationExceptionData>> handler400(MethodArgumentNotValidException exception) {
        return ResponseEntity.badRequest()
                .body(
                        exception
                                .getFieldErrors()
                                .stream()
                                .map(ValidationExceptionData::new)
                                .toList());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> handler404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(AppointmentValidationException.class)
    public ResponseEntity<ValidationExceptionData> handler400(AppointmentValidationException exception) {
        return ResponseEntity
                .badRequest()
                .body(
                        new ValidationExceptionData(
                                null,
                                exception.getMessage()));
    }

}
