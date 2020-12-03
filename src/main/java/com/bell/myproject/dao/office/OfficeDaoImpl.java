package com.bell.myproject.dao.office;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.bell.myproject.model.Office;
import com.bell.myproject.model.Organization;
import com.bell.myproject.view.office.OfficeView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OfficeDaoImpl implements OfficeDao{
    private final EntityManager em;
    private final CriteriaBuilder builder;
    
    @Autowired
    public OfficeDaoImpl(EntityManager em, CriteriaBuilder builder) {
        this.em = em;
        this.builder = builder;
    }

    @Override
    public List<Office> all(Map<String,Object> filter) {
        Predicate predicate;

        CriteriaQuery<Office> query = builder.createQuery(Office.class);
        Root<Office> rootOffice = query.from(Office.class);
        Join<Office, Organization> rootOrganization = rootOffice.join("organization");
        Predicate orgIdPredicate = builder.equal(rootOrganization.get("id"), filter.get("orgId"));
        Predicate namePredicate = builder.like(rootOffice.get("name"), "%" + filter.get("name") + "%");
        Predicate phonePredicate = builder.like(rootOffice.get("phone"), "%" + filter.get("phone") + "%");
        Predicate isActivePredicate = builder.equal(rootOffice.get("isActive"), filter.get("isActive"));
        if (filter.get("isActive") != null) {
            predicate = builder.and(orgIdPredicate, namePredicate, phonePredicate, isActivePredicate);
        } else {
            predicate = builder.and(orgIdPredicate, namePredicate, phonePredicate);
        }
        query.where(predicate);
        TypedQuery<Office> typedQuery = em.createQuery(query);
        return typedQuery.getResultList();
    }

    @Override
    public Office loadById(Long id) {
        return null;
    }

    @Override
    public void save(Office office) {
        em.persist(office);
    }

    @Override
    public void update(Office update) {
        Office currOffice = em.find(Office.class, update.getId());
        String phone = update.getPhone();
        Boolean active = update.getIsActive();

        currOffice.setAddress(update.getAddress());
        if (active != null) {
            currOffice.setIsActive(active);
        }
        currOffice.setName(update.getName());
        if (!phone.equals("")) {
            currOffice.setPhone(phone);
        }
    }

    @Override
    public Office findById(int id) {
        return em.find(Office.class, id);
    }
}
