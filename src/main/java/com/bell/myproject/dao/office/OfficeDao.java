package com.bell.myproject.dao.office;


import java.util.List;
import java.util.Map;

import com.bell.myproject.model.Office;

public interface OfficeDao {
    List<Office> all(Map<String,Object> filter);

    Office loadById(Long id);

    void save(Office office);

    void update(Office update);

    Office findById(int id);
}
