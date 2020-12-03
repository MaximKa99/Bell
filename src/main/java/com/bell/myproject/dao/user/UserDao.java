package com.bell.myproject.dao.user;

import java.util.List;

import com.bell.myproject.model.User;

public interface UserDao {
    List<User> all(User userFilter);

    User loadById(int id);

    void save(User userSave);

    void update(User userUpdate);
}
