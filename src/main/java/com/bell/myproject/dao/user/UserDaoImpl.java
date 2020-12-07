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

    public void save(User userSave) {
        User user = new User();
        Office office = em.find(Office.class, userSave.getOffice().getId());
        if (office == null)
            throw new NoSuchOfficeException("Нет такого офиса");
        user.setOffice(office);
        user.setFirstName(userSave.getFirstName());
        user.setSecondName(userSave.getSecondName());
        user.setMiddleName(userSave.getMiddleName());
        user.setPosition(userSave.getPosition());
        user.setPhone(userSave.getPhone());

        Citizenship citizenship = null;
        if (userSave.getCitizenship().getCode() != 0)
            citizenship = em.find(Citizenship.class, userSave.getCitizenship().getCode());
        if (citizenship != null)
            user.setCitizenship(citizenship);
        user.setIsIdentified(userSave.getIsIdentified());
        em.persist(user);

        Document document = null;
        if (userSave.getDocument().getDate() != null) {
            if (document == null)
                document = new Document();
            document.setDate(userSave.getDocument().getDate());
        }
        if (!userSave.getDocument().getDocName().equals("")) {
            if (document == null)
                document = new Document();
            document.setDocName(userSave.getDocument().getDocName());
        }
        if (userSave.getDocument().getDocNumber().equals("")) {
            if (document == null)
                document = new Document();
            document.setDocNumber(userSave.getDocument().getDocNumber());
        }
        TypeOfDocument typeOfDocument = null;
        if (userSave.getDocument().getType().getCode() != 0)
            typeOfDocument = em.find(TypeOfDocument.class, userSave.getDocument().getType().getCode());
        if (typeOfDocument != null)
            document.setType(typeOfDocument);
        if (document != null)
            document.setUser(user);
        if (document == null) {
            document = new Document();
        }
        em.persist(document);
    }
}
