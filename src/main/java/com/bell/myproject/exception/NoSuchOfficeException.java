package com.bell.myproject.exception;

public class NoSuchOfficeException extends RuntimeException{
    public NoSuchOfficeException(String text) {
        super(text);
    }
}
