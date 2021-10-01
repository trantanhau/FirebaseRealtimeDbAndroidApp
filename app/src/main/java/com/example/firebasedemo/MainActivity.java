package com.example.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edit_name = findViewById(R.id.edit_name);
        Button btnSubmit = findViewById(R.id.btn_submit);
        Button btnView = findViewById(R.id.btn_view);
        btnView.setOnClickListener(event -> {
            Intent intent = new Intent(MainActivity.this, ViewActivity.class);
            startActivity(intent);
        });
        DAOUser dao = new DAOUser();
        User user_edit = (User) getIntent().getSerializableExtra("EDIT");
        if (user_edit != null) {
            btnSubmit.setText("UPDATE");
            edit_name.setText(user_edit.getName());
            btnView.setVisibility(View.GONE);
        } else {
            btnSubmit.setText("SUBMIT");
            btnView.setVisibility(View.VISIBLE);
        }
        btnSubmit.setOnClickListener(event -> {
            User user = new User(edit_name.getText().toString());
            if (user_edit == null) {

                dao.add(user).addOnSuccessListener(success -> {
                    Toast.makeText(this, "Submit Success", Toast.LENGTH_SHORT).show();
                }).addOnFailureListener(error -> {
                    Toast.makeText(this, "" + error.getMessage(), Toast.LENGTH_SHORT).show();
                });
            } else {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("name", edit_name.getText().toString());
                dao.update(user_edit.getKey(), hashMap).addOnSuccessListener(success -> {
                    Toast.makeText(this, "Submit Success", Toast.LENGTH_SHORT).show();
                    finish();
                }).addOnFailureListener(error -> {
                    Toast.makeText(this, "" + error.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }

        });
    }
}