package com.bell.myproject.service.Office;

import java.util.List;

import com.bell.myproject.model.Office;
import com.bell.myproject.view.Data;
import com.bell.myproject.view.ListOfficeView;
import com.bell.myproject.view.OfficeView;

public interface OfficeService {
    /** 
     * Добавить офис
     * @param oView
     */ 

    Data save(OfficeView oView);

    Data update(OfficeView oView);

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

    List<OfficeView> offices(OfficeView officeView);

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

    static OfficeView toListResponse(Office office) {
        return new OfficeView(office.getId(), office.getName(), office.getIsActive());
    }

    static ListOfficeView toListOfficeView(OfficeView officeView) {
        return new ListOfficeView(officeView.getId(), officeView.getName(), officeView.getIsActive());
    }
}
