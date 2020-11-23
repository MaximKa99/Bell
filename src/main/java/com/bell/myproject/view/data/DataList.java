package com.bell.myproject.view.data;

import java.util.List;

import com.bell.myproject.view.View;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class DataList {
    private List<View> data;
}
