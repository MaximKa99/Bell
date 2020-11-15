package com.bell.myproject.service.Office;

import java.util.List;

import com.bell.myproject.model.Office;
import com.bell.myproject.view.OfficeView;

public interface OfficeService {
    /** 
     * Добавить офис
     * @param oView
     */ 

    void save(Office oView);

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

    List<OfficeView> offices();

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
