package com.bell.myproject.service.user;

import java.util.List;

import com.bell.myproject.view.user.UserFilterView;
import com.bell.myproject.view.user.UserListView;
import com.bell.myproject.view.user.UserSaveView;
import com.bell.myproject.view.user.UserUpdateView;
import com.bell.myproject.view.user.UserIdView;

public interface UserService {

    /**
     * Получить список юзеров
     * @return {@Organization}
     * 
     */

    List<UserListView> users(UserFilterView filter);

    void update(UserUpdateView update);

    void save(UserSaveView save);

    UserIdView findUserById(int id);
}
