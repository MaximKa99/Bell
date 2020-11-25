package com.bell.myproject.dao.user;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.bell.myproject.exception.IncorrectOfficeRequest;
import com.bell.myproject.model.Citizenship;
import com.bell.myproject.model.Document;
import com.bell.myproject.model.Office;
import com.bell.myproject.model.TypeOfDocument;
import com.bell.myproject.model.User;
import com.bell.myproject.view.user.UserView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    private final EntityManager em;
    private final CriteriaBuilder builder;

    @Autowired
    public UserDaoImpl(EntityManager em, CriteriaBuilder builder) {
        this.em = em;
        this.builder = builder;
    }

    public List<User> all(UserView userView) {
        String firstName = userView.getFirstName();
        String secondName = userView.getSecondName();
        String middleName = userView.getMiddleName();
        String position = userView.getPosition();
        int docCode = userView.getDocCode();
        int citizenshipCode = userView.getCitizenshipCode();
        Predicate predicate = null;

        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> rootUser = query.from(User.class);
        Join<User, Citizenship> joinCitizenship = rootUser.join("citizenship");
        Join<User, Document> joinDocument = rootUser.join("document");
        Join<User, Office> joinOffice = rootUser.join("office");
        Join<Document, TypeOfDocument> joinTypeOfDocument = joinDocument.join("type");

        Predicate officeIdPredicate = builder.equal(joinOffice.get("id"), userView.getOfficeId());
        Predicate firstNamePredicate = builder.like(rootUser.get("firstName"), "%" + firstName + "%");
        Predicate secondNamePredicate = builder.like(rootUser.get("secondName"), "%" + secondName + "%");
        Predicate middleNamePredicate = builder.like(rootUser.get("middleName"), "%" + middleName + "%");
        Predicate positionPredicate = builder.like(rootUser.get("position"), "%" + position + "%");
        Predicate docCodPredicate = builder.equal(joinTypeOfDocument.get("code"), docCode);
        Predicate citizenshipCodPredicate = builder.equal(joinCitizenship.get("code"), citizenshipCode);
        predicate = builder.and(officeIdPredicate, firstNamePredicate, secondNamePredicate, middleNamePredicate, positionPredicate,
            docCodPredicate, citizenshipCodPredicate);
        query.where(predicate);
        TypedQuery<User> typedQuery = em.createQuery(query);
        return typedQuery.getResultList();
    }

    public User loadById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void update(UserView userView) {
        User user = loadById(userView.getId());
        String firstName = userView.getFirstName();
        String secondName = userView.getSecondName();
        String middleName = userView.getMiddleName();
        String position = userView.getPosition();
        String phone = userView.getPhone();

        if (!firstName.equals("")) {
            user.setFirstName(firstName);
        }
        if (!secondName.equals("")){
            user.setSecondName(secondName);
        }
        if (!middleName.equals("")) {
            user.setMiddleName(middleName);
        }
        if (!position.equals("")) {
            user.setPosition(position);
        }
        if (!phone.equals("")) {
            user.setPhone(phone);
        }

        Document document = user.getDocument();
        String docName = userView.getDocName();
        Date date = userView.getDocDate();
        int docNumber = userView.getDocNumber();

        if (!docName.equals("")) {
            document.setDocName(docName);
        }
        if (docNumber != 0) {
            document.setDocNumber(docNumber);
        }
        if (date != null) {
            document.setDate(date);
        }

        Boolean isUndentified = userView.getIsUndentified();

        if (isUndentified != null) {
            user.setIsUndentified(isUndentified);
        }

        em.merge(document);
        em.merge(user);
    }

    public void save(UserView userView) {
        User user = new User();
        Office office = em.find(Office.class, userView.getOfficeId());
        if (office == null)
            throw new IncorrectOfficeRequest("Нет такого офиса");
        user.setOffice(office);
        user.setFirstName(userView.getFirstName());
        user.setSecondName(userView.getSecondName());
        user.setMiddleName(userView.getMiddleName());
        user.setPosition(userView.getPosition());
        user.setPhone(userView.getPhone());

        Citizenship citizenship = null;
        if (userView.getCitizenshipCode() != 0)
            citizenship = em.find(Citizenship.class, userView.getCitizenshipCode());
        if (citizenship != null)
            user.setCitizenship(citizenship);
        user.setIsUndentified(userView.getIsUndentified());
        em.persist(user);

        Document document = null;
        if (userView.getDocDate() != null) {
            if (document == null)
                document = new Document();
            document.setDate(userView.getDocDate());
        }
        if (!userView.getDocName().equals("")) {
            if (document == null)
                document = new Document();
            document.setDocName(userView.getDocName());
        }
        if (userView.getDocNumber() != 0) {
            if (document == null)
                document = new Document();
            document.setDocNumber(userView.getDocNumber());
        }
        TypeOfDocument typeOfDocument = null;
        if (userView.getDocCode() != 0)
            typeOfDocument = em.find(TypeOfDocument.class, userView.getDocCode());
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
