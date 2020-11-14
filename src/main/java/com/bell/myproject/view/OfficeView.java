package com.bell.myproject.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfficeView implements View{
    private int id;
    private int orgId;
    private String name;
    private String address;
    private String phone;
    private Boolean isActive;
}
