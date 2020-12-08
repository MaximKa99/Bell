package com.bell.myproject.dao.organization;

import java.util.List;
import java.util.Map;

import com.bell.myproject.model.Organization;

public interface OrganizationDao {
    
    /**
     * Обновить организацию
     * @param update
     */

    void update(Map<String, Object> update);

    /**
     * Получить список организаций с учетом фильтра
     * @param filter
     * @return List<Organization>
     */

    List<Organization> all(Map<String, Object> filter);

    /**
     * Получить организацию по id
     * @param id
     * @return Organization
     */

    Organization loadById(int id);

    /**
     * Сохранить организацию
     * @param save
     */

    void save(Organization save);
}
