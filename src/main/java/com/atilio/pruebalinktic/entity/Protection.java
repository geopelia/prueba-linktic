package com.atilio.pruebalinktic.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "amparos")
public class Protection {
    @Id
    @Column(name = "codigo", nullable = false)
    private int code;
    @Column(name = "descripcion", nullable = false, length = 200)
    private String description;

    @OneToMany(mappedBy = "protection")
    private Set<Premiums> premiums;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}