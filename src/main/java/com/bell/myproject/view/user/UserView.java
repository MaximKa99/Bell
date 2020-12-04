package com.bell.myproject.view.user;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserView{
    private Integer id;
    private int officeId;
    private String firstName;
    private String secondName;
    private String middleName;
    private String position;
    private String phone;
    private String docName;
    private String docNumber;
    private int docCode;
    private Date docDate;
    private int citizenshipCode;
    private String citizenshipName;
    private Boolean isIdentified;
}
