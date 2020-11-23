package com.bell.myproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Organization")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organization{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "full_name")
    private String fullName;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "inn")
    private String inn;
    
    @Column(name = "kpp")
    private String kpp;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "is_active")
    private Boolean isActive;

    public Organization(String name, String fullName, String address, String inn, String kpp, String phone, Boolean isActive) {
        this.name = name;
        this.fullName = fullName;
        this.address = address;
        this.inn = inn;
        this.kpp = kpp;
        this.phone = phone;
        this.isActive = isActive;
    }
}