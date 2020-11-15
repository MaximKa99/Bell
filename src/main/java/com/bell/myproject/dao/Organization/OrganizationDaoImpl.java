package com.bell.myproject.dao.Organization;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.bell.myproject.model.Organization;
import com.bell.myproject.service.Organization.OrganizationService;
import com.bell.myproject.view.OrganizationView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrganizationDaoImpl implements OrganizationDao{
    private final EntityManager em;
    private final CriteriaBuilder builder;

    @Autowired
    public OrganizationDaoImpl(EntityManager em, CriteriaBuilder builder) {
        this.em = em;
        this.builder = builder;
    }

    @Override
    public List<Organization> all(OrganizationView organizationView) {
        Predicate predicate;

        CriteriaQuery<Organization> query = builder.createQuery(Organization.class);
        Root<Organization> root = query.from(Organization.class);
        Predicate activePredicate = builder.equal(root.get("isActive"), organizationView.getIsActive());
        Predicate innPredicate = builder.like(root.get("inn"), "%" + organizationView.getInn() + "%");
        Predicate namePredicate = builder.like(root.get("name"), "%" + organizationView.getName() + "%");
        if (organizationView.getIsActive() != null) {
            predicate = builder.and(namePredicate, activePredicate, innPredicate);
        } else {
            predicate = builder.and(namePredicate, innPredicate);
        }
        query.where(predicate);
        TypedQuery<Organization> typedQuery = em.createQuery(query);
        return typedQuery.getResultList();
    }

    @Override
    public Organization loadById(int id) {
        CriteriaQuery<Organization> query = builder.createQuery(Organization.class);
        Root<Organization> root = query.from(Organization.class);
        Predicate predicate = builder.equal(root.get("id"), id);
        query.where(predicate);
        TypedQuery<Organization> typedQuery = em.createQuery(query);
        return typedQuery.getSingleResult();
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
