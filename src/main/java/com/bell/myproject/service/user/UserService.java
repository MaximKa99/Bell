package com.bell.myproject.service.user;

import java.util.List;
import com.bell.myproject.view.user.UserListView;
import com.bell.myproject.view.user.UserView;

public interface UserService {

    /**
     * Получить список юзеров
     * @return {@Organization}
     * 
     */

    List<UserListView> users(UserView userView);

    void update(UserView userView);

    void save(UserView userView);

    UserView findUserById(int id);
}
