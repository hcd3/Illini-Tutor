package com.example.illinitutorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button stuButton = findViewById(R.id.studentButton);
        Button tutButton = findViewById(R.id.tutorButton);
        Button infoButton = findViewById(R.id.infoButton);
        stuButton.setOnClickListener(args -> {
            startActivity(new Intent(this, StudentRequest.class));
        });
        tutButton.setOnClickListener(args -> {
            startActivity(new Intent(this, RequestList.class));
        });
        infoButton.setOnClickListener(args -> {
            startActivity(new Intent(this, InfoScreen.class));
        });
    }
}
