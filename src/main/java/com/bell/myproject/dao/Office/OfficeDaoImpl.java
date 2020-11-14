package com.bell.myproject.dao.Office;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.bell.myproject.model.Office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OfficeDaoImpl implements OfficeDao{
    private final EntityManager em;
    
    @Autowired
    public OfficeDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Office> all() {
        TypedQuery<Office> query = em.createQuery("SELECT o FROM Office o", Office.class);
        return query.getResultList();
    }

    @Override
    public Office loadById(Long id) {
        return null;
    }

    @Override
    public void save(Office organization) {

    }

    @Override
    public Office findById(int id) {
        TypedQuery<Office> query = em.createQuery("SELECT o FROM Office o WHERE id=" + Integer.toString(id), Office.class);
        return query.getSingleResult();
    }
}
