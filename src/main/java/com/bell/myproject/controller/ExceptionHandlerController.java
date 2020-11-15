package com.bell.myproject.controller;

import com.bell.myproject.exception.IncorrectOrganizationRequest;
import com.bell.myproject.view.Error;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler{

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Error> handleNoSuchOrganization() {
        return new ResponseEntity<>(new Error("Нет такой организации!!!"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IncorrectOrganizationRequest.class)
    public ResponseEntity<Error> handleIncorrectOrganizationRequest(IncorrectOrganizationRequest ex) {
        return new ResponseEntity<>(new Error("Отсутствует поле name!!!"), HttpStatus.BAD_REQUEST);
    }
}
