package com.bell.myproject.service.Organization;

import com.bell.myproject.model.Organization;
import com.bell.myproject.view.ListOrganizationView;
import com.bell.myproject.view.OrganizationView;
import com.bell.myproject.view.data.Data;
import com.bell.myproject.view.data.DataList;

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

    DataList organizations(OrganizationView organizationView);

    /**
     * поиск организации по id
     * @param id
     * @return Data
     */

    Data findById(int id);

    /**
     * Сконвертить OrganizationView в Organization
     * @param organizationView
     * @return
     */

    static Organization toModel(OrganizationView organizationView) {
        return new Organization(organizationView.getId(),
                                organizationView.getName(),
                                organizationView.getFullName(),
                                organizationView.getAddress(),
                                organizationView.getInn(),
                                organizationView.getKpp(),
                                organizationView.getPhone(),
                                organizationView.getIsActive());
    }

    /**
     * Сконвертить organizationView в Organization без id
     * @param organizationView
     * @return
     */

    static Organization toModelWithoutId(OrganizationView organizationView) {
        return new Organization(organizationView.getName(),
                                organizationView.getFullName(),
                                organizationView.getAddress(),
                                organizationView.getInn(),
                                organizationView.getKpp(),
                                organizationView.getPhone(),
                                organizationView.getIsActive());
    }

    /**
     * трансформируем Organization в OrganizationView 
     * @param organization
     * @return
     */

    static OrganizationView toView(Organization organization) {
        return new OrganizationView(organization.getId(),
                                    organization.getName(),
                                    organization.getFullName(),
                                    organization.getAddress(),
                                    organization.getInn(),
                                    organization.getKpp(),
                                    organization.getPhone(),
                                    organization.getIsActive());
    }

    /**
     * Сконвертить Organization в ListOrganizationView
     * @param orView
     * @return
     */

    static ListOrganizationView toListOrganizationView(Organization organization) {
        return new ListOrganizationView(organization.getId(), organization.getName(), organization.getIsActive());
    }
}