package com.bell.myproject.dao.Office;

import java.util.List;

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
    public List<Office> all(OfficeView officeView) {
        Predicate predicate;

        CriteriaQuery<Office> query = builder.createQuery(Office.class);
        Root<Office> rootOffice = query.from(Office.class);
        Join<Office, Organization> rootOrganization = rootOffice.join("organization");
        Predicate orgIdPredicate = builder.equal(rootOrganization.get("id"), officeView.getOrgId());
        Predicate namePredicate = builder.like(rootOffice.get("name"), "%" + officeView.getName() + "%");
        Predicate phonePredicate = builder.like(rootOffice.get("phone"), "%" + officeView.getPhone() + "%");
        Predicate isActivePredicate = builder.equal(rootOffice.get("isActive"), officeView.getIsActive());
        if (officeView.getIsActive() != null) {
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
    public void save(OfficeView officeView) {
        Office office = new Office();
        String address = officeView.getAddress();
        String name = officeView.getName();
        String phone = officeView.getPhone();
        Boolean active = officeView.getIsActive();
        int orgId = officeView.getOrgId();

        if (!address.equals("")) {
            office.setAddress(address);
        }
        if (!name.equals("")) {
            office.setName(name);
        }
        if (!phone.equals("")) {
            office.setPhone(phone);
        }
        if (active == null) {
            office.setIsActive(active);
        }
        if (orgId != 0) {
            office.setOrganization(em.find(Organization.class, orgId));
        }
        em.persist(office);
    }

    @Override
    public void update(OfficeView officeView) {
        Office currOffice = em.find(Office.class, officeView.getId());
        String phone = officeView.getPhone();
        Boolean active = officeView.getIsActive();

        currOffice.setAddress(officeView.getAddress());
        if (active != null) {
            currOffice.setIsActive(active);
        }
        currOffice.setName(officeView.getName());
        if (!phone.equals("")) {
            currOffice.setPhone(phone);
        }
        em.merge(currOffice);
    }

    @Override
    public Office findById(int id) {
        return em.find(Office.class, id);
    }
}
