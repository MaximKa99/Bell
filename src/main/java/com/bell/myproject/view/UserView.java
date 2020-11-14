package com.bell.myproject.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserView implements View{
    private int officeId;
    private int orgId;
    private String firstName;
    private String secondName;
    private String middleName;
    private String position;
    private String phone;
    private int docId;
    private int citizenshipId;
    private Boolean isUndentified;
}
