package com.bell.myproject.service.country;

import java.util.List;

import com.bell.myproject.dao.country.CountryDao;
import com.bell.myproject.model.Citizenship;
import com.bell.myproject.model.mapper.MapperFacade;
import com.bell.myproject.view.ListOfCitizenship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CountryServiceImpl implements CountryService {
    private CountryDao dao;
    private MapperFacade mapper;
    
    @Autowired
    public CountryServiceImpl(CountryDao dao, MapperFacade mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ListOfCitizenship> all() {
        List<Citizenship> list = dao.all();
        return mapper.mapAsList(list, ListOfCitizenship.class);
    }
}
