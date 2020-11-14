package com.bell.myproject.view;

import com.bell.myproject.model.Organization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationView implements View{
    private int id;
    private String name;
    private String fullName;
    private String address;
    private String inn;
    private String kpp;
    private String phone;
    private Boolean isActive;

    public OrganizationView(int id, String name, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }
}
