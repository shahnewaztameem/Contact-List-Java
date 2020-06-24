package com.java.contactlist;

public class Contacts {
    private String name;
    private int mobileNumber;

    public Contacts(String name, int mobileNumber) {
        this.name = name;
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

}
