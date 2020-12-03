package com.bell.myproject.view.user;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFilter {
    @Min(value = 1 ,message = "Задайте officeId")
    private int officeId;
    private String firstName;
    private String lastName;
    private String middleName;
    private String position;
    private int docCode;
    private int citizenshipCode;
}
