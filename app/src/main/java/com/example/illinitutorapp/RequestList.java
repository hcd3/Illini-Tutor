package com.example.illinitutorapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


public class RequestList extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_list);

        JsonArray requests = RequestForm.viewAll();
        if (requests == null) {
            return;
        }
        for (int i = 0; i < requests.size(); i++) {
            JsonObject request = requests.get(i).getAsJsonObject();
        }
    }
}
