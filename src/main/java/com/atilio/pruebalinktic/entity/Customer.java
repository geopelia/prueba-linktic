package com.atilio.pruebalinktic.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.IdClass;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
@Table(name = "clientes" )
@IdClass(CustomerId.class)
public class Customer {
    @Id
    @Column(name="tipo_documento", nullable=false)
    private int docType;
    @Id
    @Column(name="numero_documento", nullable=false, length=30)
    private String docName;
    @Column(name="nombres", nullable=false, length=200)
    private String firstName;
    @Column(name="apellidos", nullable=false, length=200)
    private String lastName;
    @Column(name="fecha_nacimiento", nullable=false)
    private Date birthDate;
    @Column(name="sexo", nullable=false)
    private int sex;

    public int getDocType() {
        return docType;
    }

    public void setDocType(int docType) {
        this.docType = docType;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}