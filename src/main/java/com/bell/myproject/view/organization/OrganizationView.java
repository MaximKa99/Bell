package com.bell.myproject.view.organization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationView{
    private int id;
    private String name;
    private String fullName;
    private String address;
    private String inn;
    private String kpp;
    private String phone;
    private Boolean isActive;
}
