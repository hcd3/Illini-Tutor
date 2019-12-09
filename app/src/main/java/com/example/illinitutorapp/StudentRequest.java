package com.example.illinitutorapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

// Adding a comment for later documentation
public class StudentRequest extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_request);
        Button createNew = findViewById(R.id.createNew);
        Button joinExisting = findViewById(R.id.joinExisting);
        createNew.setOnClickListener(args -> {
            startActivity(new Intent(this, RequestForm.class));
        });
        joinExisting.setOnClickListener(args -> {
            startActivity(new Intent(this, RequestList.class));
        });
    }
}
