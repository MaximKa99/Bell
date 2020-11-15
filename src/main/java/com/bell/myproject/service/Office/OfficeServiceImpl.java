package com.bell.myproject.service.Office;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.bell.myproject.dao.Office.OfficeDao;
import com.bell.myproject.model.Office;
import com.bell.myproject.view.OfficeView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OfficeServiceImpl implements OfficeService{
    private final OfficeDao dao;

    @Autowired
    public OfficeServiceImpl(OfficeDao dao) {
        this.dao = dao;
    }

    @Transactional
    public void save(Office oView) {
        dao.save(oView);
    }

    @Override
    @Transactional
    public OfficeView findById(int id) {
        Office office = dao.findById(id);
        return OfficeService.toView(office);
    }

    @Override
    @Transactional
    public List<OfficeView> offices() {
        List<Office> all = dao.all();
        return all.stream().map(OfficeService::toView).collect(Collectors.toList());
    }
}
