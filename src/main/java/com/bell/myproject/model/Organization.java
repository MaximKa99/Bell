package com.bell.myproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

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
    
    @Version
    private Integer version;
    
    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @Column(name = "full_name", length = 60, nullable = false)
    private String fullName;
    
    @Column(name = "address", length = 100, nullable = false)
    private String address;
    
    @Column(name = "inn", length = 12, nullable = false)
    private String inn;
    
    @Column(name = "kpp", length = 9, nullable = false)
    private String kpp;
    
    @Column(name = "phone", length = 15)
    private String phone;
    
    @Column(name = "is_active")
    private Boolean isActive;

}