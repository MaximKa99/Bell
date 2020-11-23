package com.bell.myproject.service.User;

import java.util.List;
import java.util.stream.Collectors;

import com.bell.myproject.dao.User.UserDao;
import com.bell.myproject.exception.NoSuchUserException;
import com.bell.myproject.model.User;
import com.bell.myproject.view.UserView;
import com.bell.myproject.view.data.Data;
import com.bell.myproject.view.data.DataList;
import com.bell.myproject.view.data.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{
    private final UserDao dao;

    @Autowired
    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public Data findUserById(int id) {
        User user = dao.loadById(id);
        if (user == null) {
            throw new NoSuchUserException("Нет такого пользавателя");
        }
        return new Data(UserService.toUserIdView(user));
    }

    @Override
    @Transactional
    public DataList users(UserView userView) {
        List<User> all = dao.all(userView);
        return new DataList(all.stream().map(UserService::toUserListView).collect(Collectors.toList()));
    }

    @Override
    @Transactional
    public Data save(UserView userView) {
        dao.save(userView);
        return new Data(new Result("Success"));
    }

    @Override
    @Transactional
    public Data update(UserView userView) {
        dao.update(userView);
        return new Data(new Result("Success"));
    }
}
