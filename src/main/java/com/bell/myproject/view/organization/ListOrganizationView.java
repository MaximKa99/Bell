package com.bell.myproject.view.organization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListOrganizationView{
    private Integer id;
    private String name;
    private Boolean isActive;
}
