package com.bell.myproject.service.office;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.bell.myproject.dao.office.OfficeDao;
import com.bell.myproject.dao.organization.OrganizationDao;
import com.bell.myproject.exception.NoSuchOfficeException;
import com.bell.myproject.exception.NoSuchOrganizationException;
import com.bell.myproject.model.Office;
import com.bell.myproject.model.Organization;
import com.bell.myproject.model.mapper.MapperFacade;
import com.bell.myproject.view.office.ListOfficeView;
import com.bell.myproject.view.office.OfficeFilter;
import com.bell.myproject.view.office.OfficeSave;
import com.bell.myproject.view.office.OfficeUpdate;
import com.bell.myproject.view.office.OfficeView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class OfficeServiceImpl implements OfficeService{
    private final OfficeDao dao;
    private final OrganizationDao orgDao;
    private final MapperFacade mapper;

    @Autowired
    public OfficeServiceImpl(OfficeDao dao, MapperFacade mapper, OrganizationDao orgDao) {
        this.dao = dao;
        this.mapper = mapper;
        this.orgDao = orgDao;
    }

    @Transactional
    public void save(OfficeSave save) {
        Office office = mapper.map(save, Office.class);
        Organization org = orgDao.loadById(save.getOrgId());
        if (org == null) {
            throw new NoSuchOrganizationException();
        }
        office.setOrganization(org);
        dao.save(office);
    }

    @Override
    @Transactional
    public void update(OfficeUpdate update) {
        Map<String, Object> updateAsMap = new HashMap<>();
        updateAsMap.put("id", update.getId());
        updateAsMap.put("name", update.getName());
        updateAsMap.put("address", update.getAddress());
        updateAsMap.put("phone", update.getPhone());
        updateAsMap.put("isActive", update.getIsActive());
        dao.update(updateAsMap);
    }

    @Override
    @Transactional(readOnly = true)
    public OfficeView findById(int id) {
        Office office = dao.findById(id);
        if (office == null) {
            throw new NoSuchOfficeException("Нет такого офиса!!!");
        }
        return mapper.map(office, OfficeView.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ListOfficeView> offices(OfficeFilter filter) {
        Map<String,Object> map = new HashMap<>();
        if(Objects.nonNull(filter)){
            map.put("orgId", filter.getOrgId());
            map.put("name", filter.getName());
            map.put("phone", filter.getPhone());
            map.put("isActive", filter.getIsActive());
        }
        List<Office> all = dao.all(map);
        return mapper.mapAsList(all, ListOfficeView.class);
    }
}
