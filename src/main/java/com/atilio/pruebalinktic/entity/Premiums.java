package com.atilio.pruebalinktic.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "primas")
public class Premiums {
    @Id
    private int id;
    @Column(name = "edad_maxima", nullable = false)
    private int maxAge;
    @Column(name = "edad_minima", nullable = false)
    private int minAge;
    @Column(name = "porcentaje_prima", nullable = false)
    private float premiumPercentage;

    @ManyToOne
    @JoinColumn(name = "codigo_amparo", nullable = false)
    private Protection protection;

    public Protection getProtection() {
        return protection;
    }

    public void setProtection(Protection protection) {
        this.protection = protection;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public float getPremiumPercentage() {
        return premiumPercentage;
    }

    public void setPremiumPercentage(float premiumPercentage) {
        this.premiumPercentage = premiumPercentage;
    }
}