package com.bell.myproject.service.Office;

import java.util.List;

import com.bell.myproject.model.Office;
import com.bell.myproject.view.office.ListOfficeView;
import com.bell.myproject.view.office.OfficeView;

public interface OfficeService {
    /** 
     * Добавить офис
     * @param oView
     */ 

    void save(OfficeView oView);

    void update(OfficeView oView);

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

    List<ListOfficeView> offices(OfficeView officeView);

    /**
     * Сконвертить Office в OfficeView
     * @param office
     * @return
     */

    static OfficeView toView(Office office) {
        return new OfficeView(office.getId(),
                            office.getOrganization().getId(),
                            office.getName(),
                            office.getAddress(),
                            office.getPhone(),
                            office.getIsActive());
    }
}
