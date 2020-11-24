package com.bell.myproject.view.office;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfficeView{
    private int id;
    private int orgId;
    private String name;
    private String address;
    private String phone;
    private Boolean isActive;

    public OfficeView(int id, String name, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }
}