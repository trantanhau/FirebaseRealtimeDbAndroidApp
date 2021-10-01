package com.example.firebasedemo;

import com.google.firebase.database.Exclude;

public class User {

    @Exclude
    private String key;
    private String name;

    public User() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
