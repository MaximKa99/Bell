package com.bell.myproject.service.Organization;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.bell.myproject.dao.Organization.OrganizationDao;
import com.bell.myproject.exception.NoSuchOrganizationException;
import com.bell.myproject.model.Organization;
import com.bell.myproject.view.OrganizationView;
import com.bell.myproject.view.data.Data;
import com.bell.myproject.view.data.DataList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService{
    private final OrganizationDao dao;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public void update(OrganizationView oView) {
        dao.update(oView);
    }

    @Override
    @Transactional
    public void save(OrganizationView oView) {
        dao.save(oView);
    }

    @Override
    @Transactional
    public Data findById(int id) {
        Organization organization = dao.loadById(id);
        if (organization == null)
            throw new NoSuchOrganizationException("Нет такой организации!!!");
        return new Data(OrganizationService.toView(organization));
    }

    @Override
    @Transactional
    public DataList organizations(OrganizationView organizationView) {
        List<Organization> all = dao.all(organizationView);
        return new DataList(all.stream().map(OrganizationService::toListOrganizationView).collect(Collectors.toList()));
    }
}
