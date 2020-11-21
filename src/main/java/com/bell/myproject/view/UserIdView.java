package com.bell.myproject.view;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserIdView implements View{
    private int id;
    private String firstName;
    private String secondName;
    private String middleName;
    private String position;
    private String phone;
    private String docName;
    private int docCode;
    private Date docDate;
    private int citizenshipCode;
    private String citizenshipName;
    private Boolean isUndentified;
}
