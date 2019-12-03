package com.example.illinitutorapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RequestForm extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_form);

        Button createRequest = findViewById(R.id.createRequest);
        createRequest.setOnClickListener(args -> {
            startActivity(new Intent(this, RequestList.class));
        });
    }
}
