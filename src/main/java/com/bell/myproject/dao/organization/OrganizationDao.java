package com.bell.myproject.dao.organization;

import java.util.List;

import com.bell.myproject.model.Organization;

public interface OrganizationDao {
    
    void update(Organization update);

    List<Organization> all(Organization filter);

    Organization loadById(int id);

    void save(Organization save);
}
