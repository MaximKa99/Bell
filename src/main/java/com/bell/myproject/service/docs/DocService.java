package com.bell.myproject.service.docs;

import java.util.List;

import com.bell.myproject.view.Doc;

public interface DocService {
    /**
     * вернуть список всех типов документов
     * @return List<Doc>
     */

    List<Doc> all();    
}
