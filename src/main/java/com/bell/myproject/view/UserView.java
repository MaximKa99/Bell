package com.bell.myproject.view;

import java.sql.Date;

import com.bell.myproject.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserView implements View{
    private int id;
    private int officeId;
    private String firstName;
    private String secondName;
    private String middleName;
    private String position;
    private String phone;
    private String docName;
    private int docNumber;
    private int docCode;
    private Date docDate;
    private int citizenshipCode;
    private String citizenshipName;
    private Boolean isUndentified;
}
