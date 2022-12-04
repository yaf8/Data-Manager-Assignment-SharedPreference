package com.example.sharedpreference2;

public class Student {
    protected String ID, FirstName, LastName;

    public Student(String ID, String firstName, String lastName) {
        this.ID = ID;
        FirstName = firstName;
        LastName = lastName;
    }

    public String getID() {
        return ID;
    }
}
