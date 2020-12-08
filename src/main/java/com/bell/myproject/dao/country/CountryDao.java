package com.bell.myproject.dao.country;

import java.util.List;

import com.bell.myproject.model.Citizenship;

public interface CountryDao {
    /**
     * Получить список всех стран
     * @return List<Citizenship>
     */

    List<Citizenship> all();
    
    /**
     * Получить Страну по code
     * @param code
     * @return Citizenship
     */

    Citizenship getByCode(int code);
}
