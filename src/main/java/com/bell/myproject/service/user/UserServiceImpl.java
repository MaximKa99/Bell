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
import com.bell.myproject.view.user.UserFilterView;
import com.bell.myproject.view.user.UserListView;
import com.bell.myproject.view.user.UserSaveView;
import com.bell.myproject.view.user.UserUpdateView;
import com.bell.myproject.view.user.UserIdView;

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
    public UserIdView findUserById(int id) {
        User user = dao.loadById(id);
        if (user == null) {
            throw new NoSuchUserException("Нет такого пользавателя");
        }
        return mapper.map(user, UserIdView.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserListView> users(UserFilterView filter) {
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
    public void save(UserSaveView save) {
        Map<String, Object> saveAsMap = new HashMap<>();
        saveAsMap.put("officeId", save.getOfficeId());
        saveAsMap.put("firstName", save.getFirstName());
        saveAsMap.put("secondName", save.getSecondName());
        saveAsMap.put("middleName", save.getMiddleName());
        saveAsMap.put("position", save.getPosition());
        saveAsMap.put("phone", save.getPhone());
        saveAsMap.put("docCode", save.getDocCode());
        saveAsMap.put("docName", save.getDocName());
        saveAsMap.put("docNumber", save.getDocNumber());
        saveAsMap.put("docDate", save.getDocDate());
        saveAsMap.put("citizenshipCode", save.getCitizenshipCode());
        saveAsMap.put("isIdentified", save.getIsIdentified());
        dao.save(saveAsMap);
    }

    @Override
    @Transactional
    public void update(UserUpdateView update) {
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
