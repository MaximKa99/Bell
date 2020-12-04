package com.bell.myproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "type_of_document")
public class TypeOfDocument {
    @Id
    private int id;

    @Column(name = "code", nullable = false)
    private int code;
    
    @Version
    private Integer version;

    @Column(name = "name", length = 115, nullable = false)
    private String name;

}
