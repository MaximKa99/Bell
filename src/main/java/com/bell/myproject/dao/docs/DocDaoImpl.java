package com.bell.myproject.dao.docs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.bell.myproject.model.TypeOfDocument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DocDaoImpl implements DocDao {
    private EntityManager em;

    @Autowired
    public DocDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<TypeOfDocument> all() {
        TypedQuery<TypeOfDocument> query = em.createQuery("SELECT d FROM TypeOfDocument d", TypeOfDocument.class);
        return query.getResultList();
    }

    @Override
    public TypeOfDocument getByCode(int code) {
        TypedQuery<TypeOfDocument> query = em.createQuery("SELECT a FROM TypeOfDocument a WHERE a.code=:code", TypeOfDocument.class);
        query.setParameter("code", code);
        return query.getSingleResult();
    }
}
