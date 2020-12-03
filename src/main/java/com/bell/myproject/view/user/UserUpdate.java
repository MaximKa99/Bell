package com.bell.myproject.view.user;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdate {
    @Min(value = 1 ,message = "Задайте id")
    private int id;
    private int officeId;
    @NotEmpty(message = "Задайте firstName")
    private String firstName;
    private String secondName;
    private String middleName;
    @NotEmpty(message = "Задайте position")
    private String position;
    private String phone;
    private String docName;
    private String docNumber;
    private Date docDate;
    private int citizenshipCode;
    private Boolean isIdentified;
}
