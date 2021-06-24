package com.example.gson_kotlin;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private int id;
    private String name;
    private int roll;
    private Address address;

    @SerializedName("familyisnameis")

    private List<familyMember> mFamily;

    public Employee(int id, String name, int roll, Address address, ArrayList<familyMember> family) {
        this.id = id;
        this.name = name;
        this.roll = roll;
        this.address = address;
        mFamily = family;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<familyMember> getmFamily() {
        return mFamily;
    }

    public void setmFamily(List<familyMember> mFamily) {
        this.mFamily = mFamily;
    }
    
}
