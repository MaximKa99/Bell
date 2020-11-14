package com.bell.myproject.service.Organization;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.bell.myproject.dao.Organization.OrganizationDao;
import com.bell.myproject.model.Organization;
import com.bell.myproject.model.mapper.MapperFacade;
import com.bell.myproject.view.OrganizationView;

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
    public OrganizationView findById(Long id) {
        Organization organization = dao.loadById(id);
        return OrganizationService.toView(organization);
    }

    @Override
    public List<OrganizationView> organizations() {
        List<Organization> all = dao.all();
        return all.stream().map(OrganizationService::toListResponse).collect(Collectors.toList());
    }
}
