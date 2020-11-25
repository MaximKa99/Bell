package com.bell.myproject.dao.user;

import java.util.List;

import com.bell.myproject.model.User;
import com.bell.myproject.view.user.UserView;

public interface UserDao {
    List<User> all(UserView userView);

    User loadById(int id);

    void save(UserView userView);

    void update(UserView userView);
}
