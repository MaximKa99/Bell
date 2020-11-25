package com.bell.myproject.dao.office;


import java.util.List;

import com.bell.myproject.model.Office;
import com.bell.myproject.view.office.OfficeView;

public interface OfficeDao {
    List<Office> all(OfficeView officeView);

    Office loadById(Long id);

    void save(OfficeView officeView);

    void update(OfficeView officeView);

    Office findById(int id);
}
