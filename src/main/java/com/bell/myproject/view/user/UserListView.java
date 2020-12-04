package com.bell.myproject.view.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserListView{
    private Integer id;
    private String firstName;
    private String secondName;
    private String middleName;
    private String position;
}
