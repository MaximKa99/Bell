package com.bell.myproject.service.organization;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bell.myproject.dao.organization.OrganizationDao;
import com.bell.myproject.exception.NoSuchOrganizationException;
import com.bell.myproject.model.Organization;
import com.bell.myproject.model.mapper.MapperFacade;
import com.bell.myproject.view.organization.OrganizationFilterView;
import com.bell.myproject.view.organization.OrganizationIdView;
import com.bell.myproject.view.organization.OrganizationListView;
import com.bell.myproject.view.organization.OrganizationSaveView;
import com.bell.myproject.view.organization.OrganizationUpdateView;

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
    public void update(OrganizationUpdateView update) {
        Map<String, Object> updateAsMap = new HashMap<>();
        updateAsMap.put("id", update.getId());
        updateAsMap.put("name", update.getName());
        updateAsMap.put("fullName", update.getFullName());
        updateAsMap.put("inn", update.getInn());
        updateAsMap.put("kpp", update.getKpp());
        updateAsMap.put("address", update.getAddress());
        updateAsMap.put("phone", update.getPhone());
        updateAsMap.put("isActive", update.getIsActive());
        dao.update(updateAsMap);
    }

    @Override
    @Transactional
    public void save(OrganizationSaveView save) {
        Organization OrgSave = mapper.map(save, Organization.class);
        dao.save(OrgSave);
    }

    @Override
    @Transactional(readOnly = true)
    public OrganizationIdView findById(int id) {
        Organization organization = dao.loadById(id);
        if (organization == null)
            throw new NoSuchOrganizationException("Нет такой организации!!!");
        return mapper.map(organization, OrganizationIdView.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrganizationListView> organizations(OrganizationFilterView filter) {
        Map<String, Object> filterAsMap = new HashMap<>();
        filterAsMap.put("name", filter.getName());
        filterAsMap.put("inn", filter.getInn());
        filterAsMap.put("isActive", filter.getIsActive());
        List<Organization> all = dao.all(filterAsMap);
        return mapper.mapAsList(all, OrganizationListView.class);
    }
}
