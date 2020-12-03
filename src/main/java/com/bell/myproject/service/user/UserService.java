package com.bell.myproject.service.user;

import java.util.List;

import com.bell.myproject.view.user.UserFilter;
import com.bell.myproject.view.user.UserListView;
import com.bell.myproject.view.user.UserSave;
import com.bell.myproject.view.user.UserUpdate;
import com.bell.myproject.view.user.UserView;

public interface UserService {

    /**
     * Получить список юзеров
     * @return {@Organization}
     * 
     */

    List<UserListView> users(UserFilter filter);

    void update(UserUpdate update);

    void save(UserSave save);

    UserView findUserById(int id);
}
