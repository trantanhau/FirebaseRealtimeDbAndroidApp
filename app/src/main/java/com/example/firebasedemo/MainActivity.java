package com.example.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edit_name = findViewById(R.id.edit_name);
        final EditText edit_age = findViewById(R.id.edit_age);
        Button btnSubmit = findViewById(R.id.btn_submit);
        DAOUser dao = new DAOUser();
        btnSubmit.setOnClickListener(event -> {
            User user = new User(edit_name.getText().toString(), edit_age.getText().toString());
            dao.add(user).addOnSuccessListener(success -> {
                Toast.makeText(this, "Submit Success", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(error -> {
                Toast.makeText(this, "" + error.getMessage(), Toast.LENGTH_SHORT).show();

            });
        });
    }
}