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

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
