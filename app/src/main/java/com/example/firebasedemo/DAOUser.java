package com.example.firebasedemo;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOUser {
    private DatabaseReference databaseReference;

    public DAOUser(){
        FirebaseDatabase fdb = FirebaseDatabase.getInstance();
        databaseReference = fdb.getReference(User.class.getSimpleName());
    }
    public Task<Void> add(User user){
        return databaseReference.push().setValue(user);
    }
}