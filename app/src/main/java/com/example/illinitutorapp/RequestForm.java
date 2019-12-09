package com.example.illinitutorapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class RequestForm extends AppCompatActivity {
    static DatabaseHelper myDb;
    Button createRequest, goToList;
    EditText name, phoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_form);
        myDb = new DatabaseHelper(this);

        createRequest = findViewById(R.id.createRequest);
        goToList = findViewById(R.id.goToList);
        name = findViewById(R.id.userPersonalInfo);
        phoneNumber = findViewById(R.id.userSessionInfo);
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
    public static JsonArray viewAll() {
        Cursor result = myDb.getAllData();
        if (result.getCount() == 0) {
            return null;
        }
        // Array to hold all requests
        JsonArray requests = new JsonArray();
        while (result.moveToNext()) {
            JsonObject request = new JsonObject();
            // Adds Personal info to JsonObject
            request.addProperty("Personal Info", result.getString(1));

            // Adds Session info to JsonObject
            request.addProperty("Session Info", result.getString(2));

            // Adds complete request
            requests.add(request);
        }
        return requests;
    }
}
