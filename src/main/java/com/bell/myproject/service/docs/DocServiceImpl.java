package com.bell.myproject.service.docs;

import java.util.List;

import com.bell.myproject.dao.docs.DocDao;
import com.bell.myproject.model.TypeOfDocument;
import com.bell.myproject.model.mapper.MapperFacade;
import com.bell.myproject.view.ListOfDocs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocServiceImpl implements DocService {
    private DocDao dao;
    private final MapperFacade mapper;

    @Autowired
    public DocServiceImpl(DocDao dao, MapperFacade mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public List<ListOfDocs> all() {
        List<TypeOfDocument> list = dao.all();
        return mapper.mapAsList(list, ListOfDocs.class);
    }
}
