package com.example.illinitutorapp;

import androidx.appcompat.app.AppCompatActivity;

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
            System.out.println();
        });
    }
}
