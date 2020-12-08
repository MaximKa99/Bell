package com.bell.myproject.dao.office;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.bell.myproject.exception.NoSuchOfficeException;
import com.bell.myproject.model.Office;
import com.bell.myproject.model.Organization;

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
    public List<Office> all(Map<String,Object> filter) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        Predicate predicate = null;

        CriteriaQuery<Office> query = builder.createQuery(Office.class);
        Root<Office> rootOffice = query.from(Office.class);
        Join<Office, Organization> rootOrganization = rootOffice.join("organization");

        List<Predicate> listOfPredicates = new ArrayList<>();
        Predicate orgIdPredicate = builder.equal(rootOrganization.get("id"), filter.get("orgId"));
        listOfPredicates.add(orgIdPredicate);
        if (!filter.get("name").equals("")) {
            Predicate namePredicate = builder.like(rootOffice.get("name"), "%" + filter.get("name") + "%");
            listOfPredicates.add(namePredicate);
        }
        if (!filter.get("phone").equals("")) {
            Predicate phonePredicate = builder.like(rootOffice.get("phone"), "%" + filter.get("phone") + "%");
            listOfPredicates.add(phonePredicate);
        }
        if (filter.get("isActive") != null) {
            Predicate isActivePredicate = builder.equal(rootOffice.get("isActive"), filter.get("isActive"));
            listOfPredicates.add(isActivePredicate);
        }

        Predicate[] arrayOfPredicates = new Predicate[listOfPredicates.size()];
        predicate = builder.and(listOfPredicates.toArray(arrayOfPredicates));

        query.where(predicate);
        TypedQuery<Office> typedQuery = em.createQuery(query);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Office office) {
        em.persist(office);
    }

    @Override
    public void update(Map<String, Object> update) {
        Office office = em.find(Office.class, update.get("id"));

        if (office == null) {
            throw new NoSuchOfficeException("не найден такой офис");
        }
        office.setAddress((String)update.get("address"));
        office.setIsActive((Boolean)update.get("isActive"));
        office.setName((String)update.get("name"));
        office.setPhone((String)update.get("phone"));
    }

    @Override
    public Office findById(int id) {
        return em.find(Office.class, id);
    }
}
