package com.bell.myproject.controller;

import java.util.UUID;

import com.bell.myproject.exception.NoSuchSmth;
import com.bell.myproject.view.error.MyError;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    Logger logger;

    @Autowired
    ExceptionController() {
        this.logger = LoggerFactory.getLogger(ExceptionController.class);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyError<String>> handleAllException(Exception e) {
        if (e instanceof MethodArgumentNotValidException) {
            BindingResult bindingResult = ((MethodArgumentNotValidException)e).getBindingResult();
            String errorText = bindingResult.getAllErrors().get(0).getDefaultMessage();
            UUID uuid = UUID.randomUUID();
            logger.error(uuid + " " + errorText);
            return new ResponseEntity<MyError<String>>(new MyError<String>(uuid + " " + errorText), HttpStatus.BAD_REQUEST);
        }
        if (e instanceof NoSuchSmth) {
            String errorText = e.getMessage();
            UUID uuid = UUID.randomUUID();
            logger.error(uuid + " " + errorText);
            return new ResponseEntity<MyError<String>>(new MyError<String>(uuid + " " + errorText), HttpStatus.NOT_FOUND);
        } else {
            UUID uuid = UUID.randomUUID();
            String errorText = "Внутренняя ошибка сервера";
            logger.error(uuid.toString(), e);
            return new ResponseEntity<MyError<String>>(new MyError<String>(uuid + " " + errorText), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
