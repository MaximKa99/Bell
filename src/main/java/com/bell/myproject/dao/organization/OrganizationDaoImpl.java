package com.bell.myproject.dao.organization;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.bell.myproject.model.Organization;
import com.bell.myproject.view.organization.OrganizationView;

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
        return em.find(Organization.class, id);
    }

    @Override
    public void update(OrganizationView organizationView) {
        Organization organization = em.find(Organization.class, organizationView.getId());
        organization.setName(organizationView.getName());
        organization.setFullName(organizationView.getFullName());
        organization.setInn(organizationView.getInn());
        organization.setKpp(organizationView.getKpp());
        organization.setIsActive(organizationView.getIsActive());
        organization.setPhone(organizationView.getPhone());
        em.merge(organization);
    }

    @Override
    public void save(OrganizationView organizationView) {
        Organization organization = new Organization();
        organization.setAddress(organizationView.getAddress());
        organization.setFullName(organizationView.getFullName());
        organization.setInn(organizationView.getInn());
        organization.setIsActive(organizationView.getIsActive());
        organization.setKpp(organizationView.getKpp());
        organization.setName(organizationView.getName());
        organization.setPhone(organizationView.getPhone());
        em.persist(organization);
    }
}
