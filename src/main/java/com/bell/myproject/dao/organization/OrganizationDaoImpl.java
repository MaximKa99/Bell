package com.bell.myproject.dao.organization;

import java.util.ArrayList;
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
    public List<Organization> all(Organization filter) {
        Predicate predicate = null;
        List<Predicate> listOfPredicates = new ArrayList<>();

        CriteriaQuery<Organization> query = builder.createQuery(Organization.class);
        Root<Organization> root = query.from(Organization.class);
        if (filter.getIsActive() != null) {
            Predicate activePredicate = builder.equal(root.get("isActive"), filter.getIsActive());
            listOfPredicates.add(activePredicate);
        }
        if (!filter.getName().equals("")) {
            Predicate innPredicate = builder.like(root.get("inn"), "%" + filter.getInn() + "%");
            listOfPredicates.add(innPredicate);
        }
        Predicate namePredicate = builder.like(root.get("name"), "%" + filter.getName() + "%");
        listOfPredicates.add(namePredicate);

        Predicate[] arrayOfPredicates = new Predicate[listOfPredicates.size()];
        predicate = builder.and(listOfPredicates.toArray(arrayOfPredicates));

        query.where(predicate);
        TypedQuery<Organization> typedQuery = em.createQuery(query);
        return typedQuery.getResultList();
    }

    @Override
    public Organization loadById(int id) {
        return em.find(Organization.class, id);
    }

    @Override
    public void update(Organization update) {
        Organization organization = em.find(Organization.class, update.getId());
        organization.setName(update.getName());
        organization.setFullName(update.getFullName());
        organization.setInn(update.getInn());
        organization.setKpp(update.getKpp());
        organization.setIsActive(update.getIsActive());
        organization.setPhone(update.getPhone());
    }

    @Override
    public void save(Organization save) {
        Organization organization = new Organization();
        organization.setAddress(save.getAddress());
        organization.setFullName(save.getFullName());
        organization.setInn(save.getInn());
        organization.setIsActive(save.getIsActive());
        organization.setKpp(save.getKpp());
        organization.setName(save.getName());
        organization.setPhone(save.getPhone());
        em.persist(organization);
    }
}
