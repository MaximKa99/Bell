package com.bell.myproject.dao.Organization;

import java.util.List;

import com.bell.myproject.model.Organization;
import com.bell.myproject.view.organization.OrganizationView;

public interface OrganizationDao {
    
    void update(OrganizationView organizationView);

    List<Organization> all(OrganizationView organizationView);

    Organization loadById(int id);

    void save(OrganizationView organizationView);
}
