package com.bell.myproject.service.Organization;

import java.util.List;

import com.bell.myproject.model.Organization;
import com.bell.myproject.view.OrganizationView;

public interface OrganizationService {
    
    void update(OrganizationView oView);

    /** 
     * Добавить организацию
     * @param oView
     */ 

    void save(OrganizationView oView);

    /**
     * Получить список организаций
     * @return {@Organization}
     * 
     */

    List<OrganizationView> organizations();

    /**
     * поиск организации по id
     * @param id
     * @return
     */

    OrganizationView findById(Long id);

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
     * трансформируем model в view 
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

    static OrganizationView toListResponse(Organization organization) {
        return new OrganizationView(organization.getId(), organization.getName(), organization.getIsActive());
    }
}
