package com.bell.myproject.dao.organization;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.bell.myproject.exception.NoSuchOrganizationException;
import com.bell.myproject.model.Organization;

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
    public List<Organization> all(Map<String, Object> filter) {
        Predicate predicate = null;
        List<Predicate> listOfPredicates = new ArrayList<>();

        CriteriaQuery<Organization> query = builder.createQuery(Organization.class);
        Root<Organization> root = query.from(Organization.class);
        if (filter.get("isActive") != null) {
            Predicate activePredicate = builder.equal(root.get("isActive"), filter.get("isActive"));
            listOfPredicates.add(activePredicate);
        }
        if (!filter.get("inn").equals("")) {
            Predicate innPredicate = builder.like(root.get("inn"), "%" + filter.get("inn") + "%");
            listOfPredicates.add(innPredicate);
        }
        Predicate namePredicate = builder.like(root.get("name"), "%" + filter.get("name") + "%");
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
    public void update(Map<String, Object> update) {
        Organization organization = em.find(Organization.class, update.get("id"));
        if (organization == null) {
            throw new NoSuchOrganizationException("нет такой организации");
        }
        organization.setName((String)update.get("name"));
        organization.setFullName((String)update.get("fullName"));
        organization.setInn((String)update.get("inn"));
        organization.setKpp((String)update.get("kpp"));
        organization.setIsActive((Boolean)update.get("isActive"));
        organization.setPhone((String)update.get("phone"));
        organization.setAddress((String)update.get("address"));
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
