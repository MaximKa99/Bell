package com.bell.myproject.exception;

public class NoSuchUserException extends RuntimeException{
    public NoSuchUserException(String text) {
        super(text);
    }
}
