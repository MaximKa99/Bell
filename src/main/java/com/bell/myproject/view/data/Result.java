package com.bell.myproject.view.data;

import com.bell.myproject.view.View;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result implements View{
    private String result;
}
