package com.bell.myproject.dao.user;

import java.util.List;
import java.util.Map;

import com.bell.myproject.model.User;

public interface UserDao {
    /**
     * Получить список юзеров с учетом фильтра
     * @param filter
     * @return List<User>
     */

    List<User> all(Map<String, Object> filter);

    /**
     * Получить пользователя по id
     * @param id
     * @return User
     */

    User loadById(int id);

    /**
     * Сохранить юзера
     * @param userSave
     */

    void save(Map<String, Object> update);

    /**
     * Обновить пользователя
     * @param userUpdate
     */

    void update(Map<String, Object> userUpdate);
}
