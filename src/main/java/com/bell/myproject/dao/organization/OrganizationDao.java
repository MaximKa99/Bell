package com.bell.myproject.dao.organization;

import java.util.List;
import java.util.Map;

import com.bell.myproject.model.Organization;

public interface OrganizationDao {
    
    void update(Organization update);

    List<Organization> all(Map<String, Object> filter);

    Organization loadById(int id);

    void save(Organization save);
}
