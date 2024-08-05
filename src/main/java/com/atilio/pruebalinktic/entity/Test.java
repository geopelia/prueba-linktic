package com.atilio.pruebalinktic.entity;

public class Test {
    private String nombre;
    private Integer age;

    public Test(String nombre, Integer age) {
        this.nombre = nombre;
        this.age = age;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}