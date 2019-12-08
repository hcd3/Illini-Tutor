package com.example.illinitutorapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RequestForm extends AppCompatActivity {
    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_form);

        Button createRequest = findViewById(R.id.createRequest);
        TextView name = findViewById(R.id.userName);
        TextView phonenumber = findViewById(R.id.userPhoneNumber);
        TextView location = findViewById(R.id.userCourse);
        createRequest.setOnClickListener(args -> {
            myDb = new DatabaseHelper(this);
            startActivity(new Intent(this, RequestList.class));
        });
    }
}
