package com.projects.restfulwebservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManualExceptionHandler extends RuntimeException {


    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(String msg) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setErrorName(msg);
        exceptionResponse.setErrorDesc("something went wrong");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
    }
    @ExceptionHandler(BusinessValidationException.class)
    public ResponseEntity handleException(BusinessValidationException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setErrorName(e.getErrorName());
        exceptionResponse.setErrorDesc(e.getErrorDesc());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }
}
