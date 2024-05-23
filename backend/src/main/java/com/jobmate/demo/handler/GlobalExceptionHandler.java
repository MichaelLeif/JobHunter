package com.jobmate.demo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.jobmate.demo.exception.AccountNotFoundException;
import com.jobmate.demo.exception.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAccountNotFoundException(AccountNotFoundException e, WebRequest web) {
        ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage(), web.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
