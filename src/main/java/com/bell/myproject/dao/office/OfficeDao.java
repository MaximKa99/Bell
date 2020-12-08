package com.bell.myproject.dao.office;


import java.util.List;
import java.util.Map;

import com.bell.myproject.model.Office;

public interface OfficeDao {
    /**
     * Получить список офисов с учетом фильтра
     * @param filter
     * @return List<Office>
     */

    List<Office> all(Map<String,Object> filter);

    /**
     * Сохранить офис
     * @param office
     */

    void save(Office office);

    /**
     * Обновить офис
     * @param update
     */

    void update(Map<String, Object> update);

    /**
     * Получить офис по id
     * @param id
     * @return Office
     */

    Office findById(int id);
}
