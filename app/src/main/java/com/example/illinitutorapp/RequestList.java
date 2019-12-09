package com.example.illinitutorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

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
        LinearLayout requestList = findViewById(R.id.requestList);
        System.out.println(requests.size());
        for (int i = 0; i < requests.size(); i++) {
            JsonObject request = requests.get(i).getAsJsonObject();
            View requestChunk = getLayoutInflater().inflate(R.layout.chunk_request,
                    requestList, false);
            // Declares 2 TextViews and 1 Button
            Button acceptRequest = requestChunk.findViewById(R.id.acceptRequest);
            TextView personalInfo = requestChunk.findViewById(R.id.personalInfo);
            TextView sessionInfo = requestChunk.findViewById(R.id.sessionInfo);
            // Adds information to TextView
            personalInfo.setText(request.get("Personal Info").getAsString());
            sessionInfo.setText(request.get("Session Info").getAsString());
            // Adds button functionality
            acceptRequest.setOnClickListener(args -> {
                // Remove request
            });

            // Final step: adds info
            requestList.addView(requestChunk);
        }
    }
}
