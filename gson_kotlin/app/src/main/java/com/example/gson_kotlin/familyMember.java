package com.example.gson_kotlin;

public class familyMember {
    private  String name;
    private String relation;
    private int age;

    public familyMember(String name, String relation, int age) {
        this.name = name;
        this.relation = relation;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
