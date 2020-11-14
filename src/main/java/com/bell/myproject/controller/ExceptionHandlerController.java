package com.bell.myproject.controller;

import com.bell.myproject.exception.NoSuchOrganizationException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler{

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<NoSuchOrganizationException> handleNoSuchOrganization() {
        return new ResponseEntity<>(new NoSuchOrganizationException("Нет такой организации!!!"), HttpStatus.NOT_FOUND);
    }
}
