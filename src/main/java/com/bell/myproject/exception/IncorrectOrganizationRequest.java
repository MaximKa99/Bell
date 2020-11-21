package com.bell.myproject.exception;

public class IncorrectOrganizationRequest extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public IncorrectOrganizationRequest(String text) {
        super(text);
    }
}
