package com.bell.myproject.controller;

import com.bell.myproject.exception.NoSuchSmth;
import com.bell.myproject.logger.LogHandler;
import com.bell.myproject.service.math.MathHelper;
import com.bell.myproject.view.error.MyError;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    LogHandler logger;
    MathHelper helper;

    @Autowired
    ExceptionController(LogHandler logger, MathHelper helper) {
        this.logger = logger;
        this.helper = helper;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyError<String>> handleAllException(Exception e) {
        if (e instanceof MethodArgumentNotValidException) {
            BindingResult bindingResult = ((MethodArgumentNotValidException)e).getBindingResult();
            String errorText = bindingResult.getAllErrors().get(0).getDefaultMessage();
            String uuid = helper.createRandomUuidAsString();
            logger.logError(errorText, uuid);
            return new ResponseEntity<MyError<String>>(new MyError<String>(uuid + " " + errorText), HttpStatus.BAD_REQUEST);
        }
        if (e instanceof NoSuchSmth) {
            String errorText = e.getMessage();
            String uuid = helper.createRandomUuidAsString();
            logger.logError(errorText, uuid);
            return new ResponseEntity<MyError<String>>(new MyError<String>(uuid + " " + errorText), HttpStatus.NOT_FOUND);
        } else {
            String uuid = helper.createRandomUuidAsString();
            String errorText = "Внутренняя ошибка сервера";
            logger.logError(e.getMessage(), uuid);
            return new ResponseEntity<MyError<String>>(new MyError<String>(uuid + " " + errorText), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
