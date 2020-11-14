package com.bell.myproject.service.User;

import java.util.List;

import com.bell.myproject.model.User;
import com.bell.myproject.view.UserView;

public interface UserService {
     /** 
     * Добавить юзера
     * @param oView
     */ 

    void save(User oView);

    /**
     * Получить список юзеров
     * @return {@Organization}
     * 
     */

    List<UserView> users();

    static UserView toView(User user) {
        return new UserView(user.getOfficeId(),
                            user.getOrgId(),
                            user.getFirstName(),
                            user.getSecondName(),
                            user.getMiddleName(),
                            user.getPosition(),
                            user.getPhone(),
                            user.getDocId(),
                            user.getCitizenshipId(),
                            user.getIsUndentified());
    }
}
