package com.bell.myproject.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Version
    private Integer version;
    
    @Column(name = "first_name", length = 30, nullable = false)
    private String firstName;
    
    @Column(name = "second_name", length = 30)
    private String secondName;
    
    @Column(name = "middle_name", length = 30)
    private String middleName;
    
    @Column(name = "position", length = 50, nullable = false)
    private String position;
    
    @Column(name = "phone", length = 15)
    private String phone;
    
    @Column(name = "is_indentified")
    private Boolean isUndentified;
    
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name = "citizenship_code")
    private Citizenship citizenship;
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private Document document;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id")
    private Office office;
}
