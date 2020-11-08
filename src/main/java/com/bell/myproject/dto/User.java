package com.bell.myproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private int officeId;
    private int orgId;
    private String firstName;
    private String secondName;
    private String middleName;
    private String position;
    private String phone;
    private Document document;
    private Country country;
    private Boolean isUndentified;
}
