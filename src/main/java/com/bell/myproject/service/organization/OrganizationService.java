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
     * @param update
     */

    void update(OrganizationUpdateView update);

    /** 
     * Добавить организацию
     * @param save
     */ 

    void save(OrganizationSaveView save);

    /**
     * Получить список организаций с учетом фильтра
     * @param OrganizationFilterList
     * @return List<OrganizationListView>
     * 
     */

    List<OrganizationListView> organizations(OrganizationFilterView filter);

    /**
     * поиск организации по id
     * @param id
     * @return OrganizationIdView
     */

    OrganizationIdView findById(int id);
}
