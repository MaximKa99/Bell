package com.bell.myproject.service.Office;

import java.util.List;

import javax.transaction.Transactional;

import com.bell.myproject.dao.Office.OfficeDao;
import com.bell.myproject.exception.NoSuchOfficeException;
import com.bell.myproject.model.Office;
import com.bell.myproject.model.mapper.MapperFacade;
import com.bell.myproject.view.office.ListOfficeView;
import com.bell.myproject.view.office.OfficeView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OfficeServiceImpl implements OfficeService{
    private final OfficeDao dao;
    private final MapperFacade mapper;

    @Autowired
    public OfficeServiceImpl(OfficeDao dao, MapperFacade mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Transactional
    public void save(OfficeView oView) {
        dao.save(oView);
    }

    @Override
    @Transactional
    public void update(OfficeView oView) {
        dao.update(oView);
    }

    @Override
    @Transactional
    public OfficeView findById(int id) {
        Office office = dao.findById(id);
        if (office == null) {
            throw new NoSuchOfficeException("Нет такого офиса!!!");
        }
        return mapper.map(office, OfficeView.class);
    }

    @Override
    @Transactional
    public List<ListOfficeView> offices(OfficeView officeView) {
        List<Office> all = dao.all(officeView);
        return mapper.mapAsList(all, ListOfficeView.class);
    }
}
