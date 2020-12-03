package com.bell.myproject.service.organization;

import java.util.List;

import com.bell.myproject.view.organization.ListOrganizationView;
import com.bell.myproject.view.organization.OrganizationFilter;
import com.bell.myproject.view.organization.OrganizationView;
import com.bell.myproject.view.organization.SaveOrganization;
import com.bell.myproject.view.organization.UpdateOrganization;

public interface OrganizationService {
    
    /**
     * Обновить организацию
     * @param oView
     */

    void update(UpdateOrganization update);

    /** 
     * Добавить организацию
     * @param oView
     */ 

    void save(SaveOrganization save);

    /**
     * Получить список организаций
     * @param OrganizationFilterList
     * @return DataList
     * 
     */

    List<ListOrganizationView> organizations(OrganizationFilter filter);

    /**
     * поиск организации по id
     * @param id
     * @return Data
     */

    OrganizationView findById(int id);
}
