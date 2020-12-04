package com.bell.myproject.controller;

import com.bell.myproject.view.error.MyError;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyError<String>> handleAllException(Exception e) {
        if (e instanceof MethodArgumentNotValidException) {
            BindingResult bindingResult = ((MethodArgumentNotValidException)e).getBindingResult();
            return new ResponseEntity<MyError<String>>(new MyError<String>(bindingResult.getAllErrors().get(0).getDefaultMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<MyError<String>>(new MyError<String>(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
