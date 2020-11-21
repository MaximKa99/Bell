package com.bell.myproject.controller;

import com.bell.myproject.exception.IncorrectOfficeRequest;
import com.bell.myproject.exception.IncorrectOrganizationRequest;
import com.bell.myproject.exception.NoSuchOfficeException;
import com.bell.myproject.exception.NoSuchOrganizationException;
import com.bell.myproject.exception.NoSuchUserException;
import com.bell.myproject.view.Error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler{

    @ExceptionHandler(NoSuchOrganizationException.class)
    public ResponseEntity<Error> handleNoSuchOrganization(NoSuchOrganizationException ex) {
        return new ResponseEntity<>(new Error(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchOfficeException.class)
    public ResponseEntity<Error> handleNoSuchOffice(NoSuchOfficeException ex) {
        return new ResponseEntity<>(new Error(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IncorrectOrganizationRequest.class)
    public ResponseEntity<Error> handleIncorrectOrganizationRequest(IncorrectOrganizationRequest ex) {
        return new ResponseEntity<>(new Error(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IncorrectOfficeRequest.class)
    public ResponseEntity<Error> handleIncorrectOfficeRequest(IncorrectOfficeRequest ex) {
        return new ResponseEntity<>(new Error(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchUserException.class)
    public ResponseEntity<Error> handleNoSuchUser(NoSuchUserException ex) {
        return new ResponseEntity<>(new Error(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
