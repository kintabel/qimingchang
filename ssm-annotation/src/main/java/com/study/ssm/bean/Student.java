package com.study.ssm.bean;

public class Student {
    private String id;
    private String name;
    private Integer age;
    private String address;

    public Student() {
    }

    public Student(String address, Integer age, String id, String name) {
        this.address = address;
        this.age = age;
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "address='" + address + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
