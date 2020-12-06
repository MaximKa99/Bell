package com.bell.myproject.exception;

public class NoSuchUserException extends RuntimeException implements NoSuchSmth{
    public NoSuchUserException(String text) {
        super(text);
    }

    public NoSuchUserException() {
        super("нет такого юзера!!!");
    }
}
