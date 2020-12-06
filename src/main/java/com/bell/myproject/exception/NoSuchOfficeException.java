package com.bell.myproject.exception;

public class NoSuchOfficeException extends RuntimeException implements NoSuchSmth{
    public NoSuchOfficeException(String text) {
        super(text);
    }

    public NoSuchOfficeException() {
        super("нет такого офиса!!!");
    }
}
