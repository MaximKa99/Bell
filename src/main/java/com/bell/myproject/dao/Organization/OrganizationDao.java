package com.bell.myproject.dao.Organization;

import java.util.List;

import com.bell.myproject.model.Organization;
import com.bell.myproject.view.OrganizationView;

public interface OrganizationDao {
    
    void update(OrganizationView organizationView);

    List<Organization> all();

    Organization loadById(Long id);

    void save(OrganizationView organizationView);
}
