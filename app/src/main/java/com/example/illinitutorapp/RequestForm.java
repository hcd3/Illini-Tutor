package com.example.illinitutorapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RequestForm extends AppCompatActivity {
    DatabaseHelper myDb;
    Button createRequest;
    EditText name;
    EditText phoneNumber;
    EditText course;
    EditText location;
    EditText dateTime;
    EditText numOfUsers;
    EditText openClosed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_form);

        createRequest = findViewById(R.id.createRequest);
        name = findViewById(R.id.userName);
        phoneNumber = findViewById(R.id.userPhoneNumber);
        course = findViewById(R.id.userCourse);
        location = findViewById(R.id.userLocation);
        dateTime = findViewById(R.id.userTime);
        numOfUsers = findViewById(R.id.userNum);
        openClosed = findViewById(R.id.userOpen);
        createRequest.setOnClickListener(args -> {
            myDb = new DatabaseHelper(this);
            startActivity(new Intent(this, RequestList.class));
            addData();
        });
    }
    public void addData() {
        createRequest.setOnClickListener(args -> {
            boolean isInserted = myDb.insertData(name.getText().toString(), phoneNumber.getText().toString(), course.getText().toString(),
                    location.getText().toString(), dateTime.getText().toString(), numOfUsers.getText().toString(),
                    openClosed.getText().toString());
            if (isInserted) {
                Toast.makeText(RequestForm.this,"Request submitted!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(RequestForm.this,"Request failed!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
