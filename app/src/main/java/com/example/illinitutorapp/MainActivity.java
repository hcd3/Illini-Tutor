package com.example.illinitutorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity {
    public static int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (counter == 0) {
            counter++;
            startActivity(new Intent(this, RequestForm.class));
        }
        // 3 buttons to go to
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
