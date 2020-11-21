package com.bell.myproject.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserListView implements View{
    private int id;
    private String firstName;
    private String secondName;
    private String middleName;
    private String position;
}
