package com.bell.myproject.view.user;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFilter {
    @NotNull(message = "Задайте officeId")
    private Integer officeId;
    private String firstName;
    private String secondName;
    private String middleName;
    private String position;
    private Integer docCode;
    private Integer citizenshipCode;
}
