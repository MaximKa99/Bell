package com.bell.myproject.service.office;

import java.util.List;

import com.bell.myproject.view.office.OfficeListView;
import com.bell.myproject.view.office.OfficeFilterView;
import com.bell.myproject.view.office.OfficeSaveView;
import com.bell.myproject.view.office.OfficeUpdateView;
import com.bell.myproject.view.office.OfficeIdView;

public interface OfficeService {
    /** 
     * Добавить офис
     * @param save
     */ 

    void save(OfficeSaveView save);

    /**
     * Обновить офис
     * @param update
     */

    void update(OfficeUpdateView update);

    /**
     * Найти по id OfficeView
     * @param id
     * @return OfficeIdView
     */

    OfficeIdView findById(int id);

    /**
     * Получить список офисов с учетом фильтра
     * @return List<OfficeListView>
     */

    List<OfficeListView> offices(OfficeFilterView filter);
}
