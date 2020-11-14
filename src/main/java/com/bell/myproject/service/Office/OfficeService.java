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

    OfficeView findById(int id);

    /**
     * Получить список офисов
     * @return {@Organization}
     * 
     */

    List<OfficeView> offices();

    static OfficeView toView(Office office) {
        return new OfficeView(office.getId(),
                            office.getOrganization().getId(),
                            office.getName(),
                            office.getAddress(),
                            office.getPhone(),
                            office.getIsActive());
    }
}
