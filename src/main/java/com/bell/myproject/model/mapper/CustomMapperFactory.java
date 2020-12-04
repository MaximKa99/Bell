package com.bell.myproject.model.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import com.bell.myproject.model.Citizenship;
import com.bell.myproject.model.Office;
import com.bell.myproject.model.Organization;
import com.bell.myproject.model.TypeOfDocument;
import com.bell.myproject.model.User;
import com.bell.myproject.view.ListOfCitizenship;
import com.bell.myproject.view.ListOfDocs;
import com.bell.myproject.view.office.ListOfficeView;
import com.bell.myproject.view.organization.ListOrganizationView;
import com.bell.myproject.view.office.OfficeView;
import com.bell.myproject.view.organization.OrganizationView;
import com.bell.myproject.view.user.UserListView;
import com.bell.myproject.view.user.UserUpdate;
import com.bell.myproject.view.user.UserView;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;

@Service
public class CustomMapperFactory implements FactoryBean<MapperFactory> {
    @Override
    public MapperFactory getObject() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder()
                .constructorResolverStrategy(null)
                .build();

        mapperFactory.classMap(Office.class, OfficeView.class)
                .field("organization.id", "orgId")
                .byDefault()
                .register();

        mapperFactory.classMap(User.class, UserView.class)
                .field("office.id", "officeId")
                .field("secondName", "secondName")
                .field("document.docName", "docName")
                .field("document.docNumber", "docNumber")
                .field("document.date", "docDate")
                .field("document.type.code", "docCode")
                .field("citizenship.code", "citizenshipCode")
                .field("citizenship.name", "citizenshipName")
                .field("isUndentified", "isUndentified")
                .byDefault()
                .register();


        mapperFactory.classMap(UserUpdate.class, User.class)
                .field("citizenshipCode", "citizenship.code")
                .field("docName", "document.docName")
                .field("docNumber", "document.docNumber")
                .field("docDate", "document.date")
                .byDefault()
                .register();
        return mapperFactory;
    }

    @Override
    public Class<?> getObjectType() {
        return MapperFactory.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
