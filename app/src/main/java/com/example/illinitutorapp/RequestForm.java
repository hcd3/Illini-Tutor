package com.example.illinitutorapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RequestForm extends AppCompatActivity {
    DatabaseHelper myDb;
    Button createRequest, goToList;
    EditText name, phoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_form);
        myDb = new DatabaseHelper(this);

        createRequest = findViewById(R.id.createRequest);
        goToList = findViewById(R.id.goToList);
        name = findViewById(R.id.userName);
        phoneNumber = findViewById(R.id.userPhoneNumber);
        createRequest.setOnClickListener(args -> {
            addData();
        });
        goToList.setOnClickListener(args -> {
            startActivity(new Intent(this, RequestList.class));
        });
    }
    public void addData() {
        boolean isInserted = myDb.insertData(name.getText().toString(), phoneNumber.getText().toString());
        if (isInserted) {
            Toast.makeText(RequestForm.this,"Request submitted!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(RequestForm.this,"Request failed!", Toast.LENGTH_SHORT).show();
        }
        name.setText("");
        phoneNumber.setText("");
    }
}
