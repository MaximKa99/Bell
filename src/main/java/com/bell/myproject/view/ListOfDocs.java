package com.bell.myproject.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListOfDocs implements View{
    private String name;
    private int code;
}