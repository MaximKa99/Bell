package com.bell.myproject.service.User;

import java.util.List;
import java.util.stream.Collectors;

import com.bell.myproject.dao.User.UserDao;
import com.bell.myproject.model.User;
import com.bell.myproject.view.UserView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserDao dao;

    @Autowired
    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    public void save(User oView) {

    }

    public List<UserView> users() {
        List<User> all = dao.all();
        return all.stream().map(UserService::toView).collect(Collectors.toList());
    }
}
