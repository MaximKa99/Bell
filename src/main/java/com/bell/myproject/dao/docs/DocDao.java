package com.bell.myproject.dao.docs;

import java.util.List;

import com.bell.myproject.model.TypeOfDocument;

public interface DocDao {
    List<TypeOfDocument> all();

    TypeOfDocument getByCode(int code);
}
