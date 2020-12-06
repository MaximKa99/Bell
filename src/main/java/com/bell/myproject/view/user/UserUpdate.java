package com.bell.myproject.view.user;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdate {
    @NotNull(message = "Задайте id")
    private Integer id;
    private Integer officeId;
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
    private Integer citizenshipCode;
    private Boolean isIdentified;
}
