package com.bell.myproject.service.Office;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.bell.myproject.dao.Office.OfficeDao;
import com.bell.myproject.exception.NoSuchOfficeException;
import com.bell.myproject.model.Office;
import com.bell.myproject.view.OfficeView;
import com.bell.myproject.view.data.Data;
import com.bell.myproject.view.data.Result;

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
    public Data save(OfficeView oView) {
        dao.save(oView);
        return new Data(new Result("Success"));
    }

    @Override
    @Transactional
    public Data update(OfficeView oView) {
        dao.update(oView);
        return new Data(new Result("Success"));
    }

    @Override
    @Transactional
    public OfficeView findById(int id) {
        Office office = dao.findById(id);
        if (office == null) {
            throw new NoSuchOfficeException("Нет такого офиса!!!");
        }
        return OfficeService.toView(office);
    }

    @Override
    @Transactional
    public List<OfficeView> offices(OfficeView officeView) {
        List<Office> all = dao.all(officeView);
        return all.stream().map(OfficeService::toListResponse).collect(Collectors.toList());
    }
}
