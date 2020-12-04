package com.bell.myproject.service.organization;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.bell.myproject.dao.organization.OrganizationDao;
import com.bell.myproject.exception.NoSuchOrganizationException;
import com.bell.myproject.model.Organization;
import com.bell.myproject.model.mapper.MapperFacade;
import com.bell.myproject.view.organization.ListOrganizationView;
import com.bell.myproject.view.organization.OrganizationFilter;
import com.bell.myproject.view.organization.OrganizationView;
import com.bell.myproject.view.organization.SaveOrganization;
import com.bell.myproject.view.organization.UpdateOrganization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void update(UpdateOrganization update) {
        Organization OrgUpdate = mapper.map(update, Organization.class);
        dao.update(OrgUpdate);
    }

    @Override
    @Transactional
    public void save(SaveOrganization save) {
        Organization OrgSave = mapper.map(save, Organization.class);
        dao.save(OrgSave);
    }

    @Override
    @Transactional(readOnly = true)
    public OrganizationView findById(int id) {
        Organization organization = dao.loadById(id);
        if (organization == null)
            throw new NoSuchOrganizationException("Нет такой организации!!!");
        return mapper.map(organization, OrganizationView.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ListOrganizationView> organizations(OrganizationFilter filter) {
        Map<String, Object> filterAsMap = new HashMap<>();
        filterAsMap.put("name", filter.getName());
        filterAsMap.put("inn", filter.getInn());
        filterAsMap.put("isActive", filter.getIsActive());
        List<Organization> all = dao.all(filterAsMap);
        return mapper.mapAsList(all, ListOrganizationView.class);
    }
}
