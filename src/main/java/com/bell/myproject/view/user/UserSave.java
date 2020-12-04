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
public class UserSave {
    @Min(value = 1 ,message = "Задайте officeId")
    private Integer officeId;
    @NotEmpty(message = "Задайте firstName")
    private String firstName;
    private String secondName;
    private String middleName;
    @NotEmpty(message = "Задайте position")
    private String position;
    private String phone;
    private int docCode;
    private String docName;
    private String docNumber;
    private Date docDate;
    private int citizenshipCode;
    private Boolean isIdentified;
}
