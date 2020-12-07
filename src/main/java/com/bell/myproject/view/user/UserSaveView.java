package com.bell.myproject.view.user;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSaveView {
    @NotNull(message = "Задайте officeId")
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
