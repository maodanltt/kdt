package com.tywh.kdt.util;

public class Student {

    private Integer id;

    private String name;

    private double height;

    private boolean merriaged;

    public Student() {
    }

    public Student(Integer id, String name, double height, boolean merriaged) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.merriaged = merriaged;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isMerriaged() {
        return merriaged;
    }

    public void setMerriaged(boolean merriaged) {
        this.merriaged = merriaged;
    }
}
