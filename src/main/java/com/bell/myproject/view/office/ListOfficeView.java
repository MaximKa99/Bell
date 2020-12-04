package com.bell.myproject.view.office;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListOfficeView {
    private Integer id;
    private String name;
    private Boolean isActive;
}
