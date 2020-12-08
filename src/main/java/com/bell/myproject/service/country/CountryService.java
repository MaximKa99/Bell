package com.bell.myproject.service.country;

import java.util.List;

import com.bell.myproject.view.CitizenshipView;

public interface CountryService {
    /**
     * Получить список всех стран
     * @return List<CitizenshipView>
     */

    List<CitizenshipView> all();
}
