package com.bell.myproject.dao.User;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.bell.myproject.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    private final EntityManager em;
    
    @Autowired
    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }

    public List<User> all() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    public User loadById(Long id) {
        return null;
    }

    public void save(User user) {

    }    
}
