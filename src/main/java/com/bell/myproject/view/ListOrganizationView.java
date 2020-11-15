package com.bell.myproject.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListOrganizationView implements View{
    private int id;
    private String name;
    private Boolean isActive;
}
