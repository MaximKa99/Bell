package com.bell.myproject.dao.country;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.bell.myproject.model.Citizenship;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

@Repository
public class CountryDaoImpl implements CountryDao {
    private EntityManager em;

    @Autowired
    public CountryDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Citizenship> all() {
        TypedQuery<Citizenship> query = em.createQuery("SELECT a FROM Citizenship a", Citizenship.class);
        return query.getResultList();
    }

    @Override
    public Citizenship getByCode(int code) {
        TypedQuery<Citizenship> query = em.createQuery("SELECT a FROM Citizenship a WHERE a.code=:code", Citizenship.class);
        query.setParameter("code", code);
        return query.getSingleResult();
    }
}
