package com.bell.myproject.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncorrectOrganizationRequest extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String error;
}
