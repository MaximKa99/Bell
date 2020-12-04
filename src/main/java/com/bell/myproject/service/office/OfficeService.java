package com.bell.myproject.service.office;

import java.util.List;

import com.bell.myproject.view.office.ListOfficeView;
import com.bell.myproject.view.office.OfficeFilter;
import com.bell.myproject.view.office.OfficeSave;
import com.bell.myproject.view.office.OfficeUpdate;
import com.bell.myproject.view.office.OfficeView;

public interface OfficeService {
    /** 
     * Добавить офис
     * @param oView
     */ 

    void save(OfficeSave save);

    void update(OfficeUpdate update);

    /**
     * Найти по id OfficeView
     * @param id
     * @return OfficeView
     */

    OfficeView findById(int id);

    /**
     * Получить список офисов
     * @return {@Organization}
     * 
     */

    List<ListOfficeView> offices(OfficeFilter filter);
}