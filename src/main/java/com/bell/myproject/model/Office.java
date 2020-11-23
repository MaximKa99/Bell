package com.bell.myproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bell.myproject.view.OfficeView;
import com.bell.myproject.view.UserView;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Office")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Office{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id")
    private Organization organization;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "is_active")
    private Boolean isActive;

    static public Office toModel(OfficeView officeView, Organization organization) {
        Office office = new Office();

        office.setAddress(officeView.getAddress());
        office.setIsActive(officeView.getIsActive());
        office.setName(officeView.getName());
        office.setOrganization(organization);
        office.setPhone(officeView.getPhone());

        return office;
    }

    static public Office toModel(OfficeView officeView) {
        Office office = new Office();

        office.setId(officeView.getId());
        office.setAddress(officeView.getAddress());
        office.setIsActive(officeView.getIsActive());
        office.setName(officeView.getName());
        office.setPhone(officeView.getPhone());

        return office;
    }
}