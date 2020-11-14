package com.bell.myproject.dao.Organization;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.bell.myproject.model.Organization;
import com.bell.myproject.service.Organization.OrganizationService;
import com.bell.myproject.view.OrganizationView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrganizationDaoImpl implements OrganizationDao{
    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Organization> all() {
        TypedQuery<Organization> query = em.createQuery("SELECT o FROM Organization o", Organization.class);
        return query.getResultList();
    }

    @Override
    public Organization loadById(Long id) {
        TypedQuery<Organization> query = em.createQuery("SELECT o FROM Organization o WHERE id=" + Long.toString(id), Organization.class);
        return query.getSingleResult();
    }

    @Override
    public void update(OrganizationView organizationView) {
        em.merge(OrganizationService.toModel(organizationView));
    }

    @Override
    public void save(OrganizationView organizationView) {
        em.persist(OrganizationService.toModelWithoutId(organizationView));
    }
}
