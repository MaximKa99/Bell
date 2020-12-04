package com.bell.myproject.dao.user;

import java.util.List;
import java.util.Map;

import com.bell.myproject.model.User;

public interface UserDao {
    List<User> all(Map<String, Object> filter);

    User loadById(int id);

    void save(User userSave);

    void update(User userUpdate);
}
