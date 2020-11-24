package com.bell.myproject.service.Organization;

import java.util.List;

import javax.transaction.Transactional;

import com.bell.myproject.dao.Organization.OrganizationDao;
import com.bell.myproject.exception.NoSuchOrganizationException;
import com.bell.myproject.model.Organization;
import com.bell.myproject.model.mapper.MapperFacade;
import com.bell.myproject.view.organization.ListOrganizationView;
import com.bell.myproject.view.organization.OrganizationView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService{
    private OrganizationDao dao;
    private MapperFacade mapper;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao dao, MapperFacade mapper) {
        this.dao = dao;
        this.mapper = mapper;
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
    public OrganizationView findById(int id) {
        Organization organization = dao.loadById(id);
        if (organization == null)
            throw new NoSuchOrganizationException("Нет такой организации!!!");
        return mapper.map(organization, OrganizationView.class);
    }

    @Override
    @Transactional
    public List<ListOrganizationView> organizations(OrganizationView organizationView) {
        List<Organization> all = dao.all(organizationView);
        return mapper.mapAsList(all, ListOrganizationView.class);
    }
}
