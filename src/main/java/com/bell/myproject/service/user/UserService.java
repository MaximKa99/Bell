package com.bell.myproject.service.user;

import java.util.List;

import com.bell.myproject.view.user.UserFilterView;
import com.bell.myproject.view.user.UserListView;
import com.bell.myproject.view.user.UserSaveView;
import com.bell.myproject.view.user.UserUpdateView;
import com.bell.myproject.view.user.UserIdView;

public interface UserService {

    /**
     * Получить список юзеров с учетом фильтра
     * @param filter
     * @return List<UserListView>
     * 
     */

    List<UserListView> users(UserFilterView filter);

    /**
     * Обновить юзера
     * @param update
     */

    void update(UserUpdateView update);
    
    /**
    * Сохранить юзера
    * @param save
    */
    
    void save(UserSaveView save);

    /**
     * Найти юзера по id
     * @param id
     * @return UserIdView
     */

    UserIdView findUserById(int id);
}
