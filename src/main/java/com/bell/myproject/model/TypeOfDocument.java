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
    private int code;

    @Column(name = "name")
    private String name;

    @Version
    private Integer version;
}
