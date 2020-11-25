package com.bell.myproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bell.myproject.dao.organization.OrganizationDao;
import com.bell.myproject.model.Organization;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrganizationDaoTest {
    @Autowired
    private OrganizationDao dao;

    @Test
    public void findByIdTest(int id) {
        Organization organization = dao.loadById(id);
        assertEquals(1, organization.getId());
    }

    
}
