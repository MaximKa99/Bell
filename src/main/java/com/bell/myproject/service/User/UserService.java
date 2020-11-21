package com.bell.myproject.service.User;

import java.util.List;

import com.bell.myproject.model.Citizenship;
import com.bell.myproject.model.Document;
import com.bell.myproject.model.Office;
import com.bell.myproject.model.User;
import com.bell.myproject.view.Data;
import com.bell.myproject.view.DataList;
import com.bell.myproject.view.UserIdView;
import com.bell.myproject.view.UserListView;
import com.bell.myproject.view.UserView;

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
