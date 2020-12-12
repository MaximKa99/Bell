package com.bell.myproject.dao.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.bell.myproject.dao.country.CountryDao;
import com.bell.myproject.exception.NoSuchOfficeException;
import com.bell.myproject.exception.NoSuchUserException;
import com.bell.myproject.model.Citizenship;
import com.bell.myproject.model.Document;
import com.bell.myproject.model.Office;
import com.bell.myproject.model.TypeOfDocument;
import com.bell.myproject.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    private final EntityManager em;
    private final CountryDao countryDao;

    @Autowired
    public UserDaoImpl(EntityManager em, CountryDao countryDao) {
        this.em = em;
        this.countryDao = countryDao;
    }

    public List<User> all(Map<String, Object> filter) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        List<Predicate> listOfPredicates = new ArrayList<>();

        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> rootUser = query.from(User.class);
        Join<User, Citizenship> joinCitizenship = rootUser.join("citizenship");
        Join<User, Document> joinDocument = rootUser.join("document");
        Join<User, Office> joinOffice = rootUser.join("office");
        Join<Document, TypeOfDocument> joinTypeOfDocument = joinDocument.join("type");

        Predicate officeIdPredicate = builder.equal(joinOffice.get("id"), filter.get("officeId"));
        listOfPredicates.add(officeIdPredicate);
        if (filter.get("firstName") != null) {
            Predicate firstNamePredicate = builder.like(rootUser.get("firstName"), "%" + filter.get("firstName") + "%");
            listOfPredicates.add(firstNamePredicate);
        }
        
        if (filter.get("secondName") != null) {
            Predicate secondNamePredicate = builder.like(rootUser.get("secondName"), "%" + filter.get("secondName") + "%");
            listOfPredicates.add(secondNamePredicate);}
        
        if (filter.get("middleName") != null) {
            Predicate middleNamePredicate = builder.like(rootUser.get("middleName"), "%" + filter.get("middleName") + "%");
            listOfPredicates.add(middleNamePredicate);
        }
        
        if (filter.get("position") != null) {
            Predicate positionPredicate = builder.like(rootUser.get("position"), "%" + filter.get("position") + "%");
            listOfPredicates.add(positionPredicate);
        }
        
        if (filter.get("docCode") != null) {
            Predicate docCodPredicate = builder.equal(joinTypeOfDocument.get("code"), filter.get("docCode"));
            listOfPredicates.add(docCodPredicate);
        }
        
        if (filter.get("citizenshipCode") != null) {
            Predicate citizenshipCodPredicate = builder.equal(joinCitizenship.get("code"), filter.get("citizenshipCode"));
            listOfPredicates.add(citizenshipCodPredicate);
        }
        

        Predicate[] arrayOfPredicate = new Predicate[listOfPredicates.size()];
        Predicate predicate = null;
        predicate = builder.and(listOfPredicates.toArray(arrayOfPredicate));

        query.where(predicate);
        TypedQuery<User> typedQuery = em.createQuery(query);
        return typedQuery.getResultList();
    }

    public User loadById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void update(Map<String, Object> update) {
        User user = em.find(User.class, update.get("id"));

        if (user == null) {
            throw new NoSuchUserException("нет такого юзера");
        }
        if (update.get("officeId") != null) {
            Office office = em.find(Office.class, update.get("officeId"));
            if (office == null) {
                throw new NoSuchOfficeException("нет такого офиса!");
            }
            user.setOffice(office);
        } else {
            user.setOffice(null);
        }
        user.setFirstName((String)update.get("firstName"));
        user.setSecondName((String)update.get("secondName"));
        user.setMiddleName((String)update.get("middleName"));
        user.setPosition((String)update.get("position"));
        user.setPhone((String)update.get("phone"));

        Document document = user.getDocument();

        document.setDocName((String)update.get("docName"));
        document.setDocNumber((String)update.get("docNumber"));
        document.setDate((Date)update.get("docDate"));


        user.setIsIdentified((Boolean)update.get("isIdentified"));

        if (update.get("citizenshipCode") != null) {
            Citizenship citizenship = countryDao.getByCode((Integer)update.get("citizenshipCode"));
            user.setCitizenship(citizenship);
        } else {
            user.setCitizenship(null);
        }

    }

    public void save(Map<String, Object> save) {
        User newUser = new User();
        Office office = em.find(Office.class, (Integer)save.get("officeId"));
        if (office == null) {
            throw new NoSuchOfficeException();
        }
        newUser.setOffice(office);
        newUser.setFirstName((String)save.get("firstName"));
        newUser.setPosition((String)save.get("position"));
        if (save.get("citizenshipCode") != null) {
            Citizenship citizenship = em.find(Citizenship.class, (Integer)save.get("citizenshipCode"));
            newUser.setCitizenship(citizenship);
        }
        if (save.get("secondName") != null) {
            newUser.setSecondName((String)save.get("secondName"));
        }
        if (save.get("middleName") != null) {
            newUser.setMiddleName((String)save.get("middleName"));
        }
        if (save.get("phone") != null) {
            newUser.setPhone("phone");
        }
        if (save.get("isIdentified") != null) {
            newUser.setIsIdentified((Boolean)save.get("isIdentified"));
        }
        Document document = new Document();
        if (save.get("docCode") != null) {
            TypeOfDocument type = em.find(TypeOfDocument.class, save.get("docCode"));
            if (type != null) {
                document.setType(type);
            }
        }
        if (save.get("docName") != null) {
            document.setDocName((String)save.get("docName"));
        }
        if (save.get("docNumber") != null) {
            document.setDocNumber((String)save.get("docNumber"));
        }
        if (save.get("docDate") != null) {
            document.setDate((Date)save.get("docDate"));
        }
        document.setUser(newUser);
        newUser.setOffice(office);
        em.persist(newUser);
        em.persist(document);
    }
}
