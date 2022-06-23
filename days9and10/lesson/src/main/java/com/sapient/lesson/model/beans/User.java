package com.sapient.lesson.model.beans;

import java.time.LocalDate;

// Class with encapsulation (private properties) and getters and setters
// is called a "Java bean" because it is passed around to different classes
// each using the getters and setters as they see fit.
public class User {
    private String name;
    private int userId;
    private LocalDate dob;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
