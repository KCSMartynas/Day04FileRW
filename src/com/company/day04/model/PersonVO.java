package com.company.day04.model;

public class PersonVO {
    private String name;
    private Integer age;
    private Integer height;
    private String color;

    public PersonVO() {
    }

    public PersonVO(String name, Integer age, Integer height, String color) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
