package com.bell.myproject.dao.User;

import java.util.List;

import com.bell.myproject.model.User;

public interface UserDao {
    List<User> all();

    User loadById(Long id);

    void save(User user);    
}
