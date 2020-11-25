package com.bell.myproject.service.organization;

import java.util.List;

import com.bell.myproject.view.organization.ListOrganizationView;
import com.bell.myproject.view.organization.OrganizationView;

public interface OrganizationService {
    
    /**
     * Обновить организацию
     * @param oView
     */

    void update(OrganizationView oView);

    /** 
     * Добавить организацию
     * @param oView
     */ 

    void save(OrganizationView oView);

    /**
     * Получить список организаций
     * @param organizationView
     * @return DataList
     * 
     */

    List<ListOrganizationView> organizations(OrganizationView organizationView);

    /**
     * поиск организации по id
     * @param id
     * @return Data
     */

    OrganizationView findById(int id);
}
