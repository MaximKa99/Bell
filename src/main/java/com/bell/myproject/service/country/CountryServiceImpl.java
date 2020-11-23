package com.bell.myproject.service.country;

import java.util.List;
import java.util.stream.Collectors;

import com.bell.myproject.dao.country.CountryDao;
import com.bell.myproject.model.Citizenship;
import com.bell.myproject.view.ListOfCitizenship;
import com.bell.myproject.view.data.DataList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {
    private CountryDao dao;
    
    @Autowired
    public CountryServiceImpl(CountryDao dao) {
        this.dao = dao;
    }

    private static ListOfCitizenship toListOfCitizenshipView(Citizenship citizenship) {
        return new ListOfCitizenship(citizenship.getName(), citizenship.getCode());
    }

    @Override
    public DataList all() {
        List<Citizenship> list = dao.all();
        return new DataList(list.stream().map(CountryServiceImpl::toListOfCitizenshipView).collect(Collectors.toList()));
    }
}
