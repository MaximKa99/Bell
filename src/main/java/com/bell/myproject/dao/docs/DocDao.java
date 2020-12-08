package com.bell.myproject.dao.docs;

import java.util.List;

import com.bell.myproject.model.TypeOfDocument;

public interface DocDao {
    /**
     * Получить список типов документов
     * @return List<TypeOfDocument>
     */
    List<TypeOfDocument> all();

    /**
     * Получить тип документа по code
     * @param code
     * @return
     */

    TypeOfDocument getByCode(int code);
}
