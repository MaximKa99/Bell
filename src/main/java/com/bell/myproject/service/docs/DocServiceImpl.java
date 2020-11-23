package com.bell.myproject.service.docs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bell.myproject.dao.docs.DocDao;
import com.bell.myproject.model.TypeOfDocument;
import com.bell.myproject.view.ListOfDocs;
import com.bell.myproject.view.data.DataList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocServiceImpl implements DocService {
    private DocDao dao;

    @Autowired
    public DocServiceImpl(DocDao dao) {
        this.dao = dao;
    }

    private static ListOfDocs toListOfDocs(TypeOfDocument type) {
        return new ListOfDocs(type.getName(), type.getCode());
    }

    @Override
    public DataList all() {
        List<TypeOfDocument> list = dao.all();
        return new DataList(list.stream().map(DocServiceImpl::toListOfDocs).collect(Collectors.toList()));
    }
}
