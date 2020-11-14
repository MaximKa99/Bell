package com.bell.myproject.dao.Office;


import java.util.List;

import com.bell.myproject.model.Office;

public interface OfficeDao {
    List<Office> all();

    Office loadById(Long id);

    void save(Office office);

    Office findById(int id);
}
