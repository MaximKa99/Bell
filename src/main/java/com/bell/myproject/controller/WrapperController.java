package com.bell.myproject.controller;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintDeclarationException;
import javax.validation.ConstraintViolationException;

import com.bell.myproject.exception.IncorrectOfficeRequest;
import com.bell.myproject.exception.IncorrectOrganizationRequest;
import com.bell.myproject.exception.NoSuchOfficeException;
import com.bell.myproject.exception.NoSuchOrganizationException;
import com.bell.myproject.exception.NoSuchUserException;
import com.bell.myproject.view.data.Data;
import com.bell.myproject.view.error.MyError;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class WrapperController implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        Method method = returnType.getMethod();
        if (method.isAnnotationPresent(ExceptionHandler.class)) {
            return false;
        }
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
            Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
            ServerHttpResponse response) {
        return new Data<>(body);
    }

    @ExceptionHandler(NoSuchOrganizationException.class)
    public ResponseEntity<MyError> handleNoSuchOrganization(NoSuchOrganizationException ex) {
        return new ResponseEntity<>(new MyError(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchOfficeException.class)
    public ResponseEntity<MyError> handleNoSuchOffice(NoSuchOfficeException ex) {
        return new ResponseEntity<>(new MyError(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IncorrectOrganizationRequest.class)
    public ResponseEntity<MyError> handleIncorrectOrganizationRequest(IncorrectOrganizationRequest ex) {
        return new ResponseEntity<>(new MyError(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IncorrectOfficeRequest.class)
    public ResponseEntity<MyError> handleIncorrectOfficeRequest(IncorrectOfficeRequest ex) {
        return new ResponseEntity<>(new MyError(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchUserException.class)
    public ResponseEntity<MyError> handleNoSuchUser(NoSuchUserException ex) {
        return new ResponseEntity<>(new MyError(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MyError> handleConstraintViolationException(MethodArgumentNotValidException e) {
        // String errorDescription = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        List<String> errorsText = errors.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
        if (errorsText.size() == 1) {
            return new ResponseEntity<>(new MyError(errorsText.get(0)), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new MyError(errorsText), HttpStatus.BAD_REQUEST);
  }
}
