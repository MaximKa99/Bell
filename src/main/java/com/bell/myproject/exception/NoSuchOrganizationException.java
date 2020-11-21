package com.bell.myproject.exception;

public class NoSuchOrganizationException extends RuntimeException{
    public NoSuchOrganizationException(String text) {
        super(text);
    }
}
