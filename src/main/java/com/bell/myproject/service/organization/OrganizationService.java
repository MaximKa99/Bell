package com.bell.myproject.service.organization;

import java.util.List;

import com.bell.myproject.view.organization.OrganizationFilterView;
import com.bell.myproject.view.organization.OrganizationIdView;
import com.bell.myproject.view.organization.OrganizationListView;
import com.bell.myproject.view.organization.OrganizationSaveView;
import com.bell.myproject.view.organization.OrganizationUpdateView;

public interface OrganizationService {
    
    /**
     * Обновить организацию
     * @param oView
     */

    void update(OrganizationUpdateView update);

    /** 
     * Добавить организацию
     * @param oView
     */ 

    void save(OrganizationSaveView save);

    /**
     * Получить список организаций
     * @param OrganizationFilterList
     * @return DataList
     * 
     */

    List<OrganizationListView> organizations(OrganizationFilterView filter);

    /**
     * поиск организации по id
     * @param id
     * @return Data
     */

    OrganizationIdView findById(int id);
}
