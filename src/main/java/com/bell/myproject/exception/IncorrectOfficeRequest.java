package com.bell.myproject.exception;

public class IncorrectOfficeRequest extends RuntimeException{

    public IncorrectOfficeRequest(String text) {
        super(text);
    }
    
}
