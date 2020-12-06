package com.bell.myproject.exception;

public class NoSuchOrganizationException extends RuntimeException implements NoSuchSmth{
    public NoSuchOrganizationException() {
        super("нет такой организации!!!");
    }

    public NoSuchOrganizationException(String text) {
        super(text);
    }
}
