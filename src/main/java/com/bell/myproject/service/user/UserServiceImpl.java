package com.bell.myproject.service.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bell.myproject.dao.country.CountryDao;
import com.bell.myproject.dao.docs.DocDao;
import com.bell.myproject.dao.office.OfficeDao;
import com.bell.myproject.dao.user.UserDao;
import com.bell.myproject.exception.NoSuchUserException;
import com.bell.myproject.model.Citizenship;
import com.bell.myproject.model.Document;
import com.bell.myproject.model.Office;
import com.bell.myproject.model.TypeOfDocument;
import com.bell.myproject.model.User;
import com.bell.myproject.model.mapper.MapperFacade;
import com.bell.myproject.view.user.UserFilter;
import com.bell.myproject.view.user.UserListView;
import com.bell.myproject.view.user.UserSave;
import com.bell.myproject.view.user.UserUpdate;
import com.bell.myproject.view.user.UserView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{
    private final UserDao dao;
    private final MapperFacade mapper;
    private final CountryDao countryDao;
    private final OfficeDao OfficeDao;
    private final DocDao docDao;

    @Autowired
    public UserServiceImpl(UserDao dao, MapperFacade mapper, CountryDao countryDao,
        OfficeDao officeDao, DocDao docDao) {
        this.dao = dao;
        this.mapper = mapper;
        this.countryDao = countryDao;
        this.OfficeDao = officeDao;
        this.docDao = docDao;
    }

    @Override
    @Transactional(readOnly = true)
    public UserView findUserById(int id) {
        User user = dao.loadById(id);
        if (user == null) {
            throw new NoSuchUserException("Нет такого пользавателя");
        }
        return mapper.map(user, UserView.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserListView> users(UserFilter filter) {
        Map<String, Object> filterAsMap = new HashMap<>();
        filterAsMap.put("officeId", filter.getOfficeId());
        filterAsMap.put("firstName", filter.getFirstName());
        filterAsMap.put("secondName", filter.getSecondName());
        filterAsMap.put("middleName", filter.getMiddleName());
        filterAsMap.put("position", filter.getPosition());
        filterAsMap.put("docCode", filter.getDocCode());
        filterAsMap.put("citizenshipCode", filter.getCitizenshipCode());
        List<User> all = dao.all(filterAsMap);
        return mapper.mapAsList(all, UserListView.class);
    }

    @Override
    @Transactional
    public void save(UserSave save) {
        User userSave = mapper.map(save, User.class);
        Office office = OfficeDao.findById(save.getOfficeId());
        userSave.setOffice(office);
        Citizenship citizenship = countryDao.getByCode(save.getCitizenshipCode());
        userSave.setCitizenship(citizenship);
        Document document = new Document();
        document.setDocName(save.getDocName());
        document.setDate(save.getDocDate());
        document.setDocNumber(save.getDocNumber());
        TypeOfDocument type = docDao.getByCode(save.getDocCode());
        document.setType(type);
        userSave.setDocument(document);
        dao.save(userSave);
    }

    @Override
    @Transactional
    public void update(UserUpdate update) {
        Map<String, Object> updateAsMap = new HashMap<>();
        updateAsMap.put("id", update.getId());
        updateAsMap.put("officeId", update.getOfficeId());
        updateAsMap.put("firstName", update.getFirstName());
        updateAsMap.put("secondName", update.getSecondName());
        updateAsMap.put("position", update.getPosition());
        updateAsMap.put("phone", update.getPhone());
        updateAsMap.put("docName", update.getDocName());
        updateAsMap.put("docNumber", update.getDocNumber());
        updateAsMap.put("docDate", update.getDocDate());
        updateAsMap.put("citizenshipCode", update.getCitizenshipCode());
        updateAsMap.put("isIdentified", update.getIsIdentified());
        dao.update(updateAsMap);
    }
}
