package com.example.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        Button btnSubmit = findViewById(R.id.btn_submit);
        Button btnView = findViewById(R.id.btn_view);
        DAOUser dao = new DAOUser();
        User user_edit = (User) getIntent().getSerializableExtra("Edit");
        btnSubmit.setOnClickListener(event -> {
            User user = new User(edit_name.getText().toString());
            dao.add(user).addOnSuccessListener(success -> {
                Toast.makeText(this, "Submit Success", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(error -> {
                Toast.makeText(this, "" + error.getMessage(), Toast.LENGTH_SHORT).show();

            });
        });
        btnView.setOnClickListener(event -> {
            Intent intent = new Intent(MainActivity.this, ViewActivity.class);
            startActivity(intent);
        });
    }
}