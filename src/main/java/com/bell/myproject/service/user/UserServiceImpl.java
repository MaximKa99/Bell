package com.bell.myproject.service.user;

import java.util.List;

import com.bell.myproject.dao.user.UserDao;
import com.bell.myproject.exception.NoSuchUserException;
import com.bell.myproject.model.User;
import com.bell.myproject.model.mapper.MapperFacade;
import com.bell.myproject.view.user.UserListView;
import com.bell.myproject.view.user.UserView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{
    private final UserDao dao;
    private final MapperFacade mapper;

    @Autowired
    public UserServiceImpl(UserDao dao, MapperFacade mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public UserView findUserById(int id) {
        User user = dao.loadById(id);
        if (user == null) {
            throw new NoSuchUserException("Нет такого пользавателя");
        }
        return mapper.map(user, UserView.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserListView> users(UserView userView) {
        List<User> all = dao.all(userView);
        return mapper.mapAsList(all, UserListView.class);
    }

    @Override
    @Transactional
    public void save(UserView userView) {
        dao.save(userView);
    }

    @Override
    @Transactional
    public void update(UserView userView) {
        dao.update(userView);
    }
}
