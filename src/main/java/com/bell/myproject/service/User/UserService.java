package com.bell.myproject.service.User;

import com.bell.myproject.model.User;
import com.bell.myproject.view.UserIdView;
import com.bell.myproject.view.UserListView;
import com.bell.myproject.view.UserView;
import com.bell.myproject.view.data.Data;
import com.bell.myproject.view.data.DataList;

public interface UserService {

    /**
     * Получить список юзеров
     * @return {@Organization}
     * 
     */

    DataList users(UserView userView);

    Data update(UserView userView);

    Data save(UserView userView);

    Data findUserById(int id);

    static UserIdView toUserIdView(User user) {
        return new UserIdView(user.getId(),
                            user.getFirstName(),
                            user.getSecondName(),
                            user.getMiddleName(),
                            user.getPosition(),
                            user.getPhone(),
                            user.getDocument().getType().getName(),
                            user.getDocument().getDocNumber(),
                            user.getDocument().getDate(),
                            user.getCitizenship().getCode(),
                            user.getCitizenship().getName(),
                            user.getIsUndentified());
    }

    static UserListView toUserListView(User user) {
        return new UserListView(user.getId(), user.getFirstName(), user.getSecondName(),
        user.getMiddleName(), user.getPosition());
    }
}
