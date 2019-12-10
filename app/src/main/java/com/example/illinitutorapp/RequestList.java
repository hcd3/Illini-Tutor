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
        LinearLayout requestList0 = findViewById(R.id.requestList0);
        LinearLayout requestList1 = findViewById(R.id.requestList1);
        LinearLayout requestList2 = findViewById(R.id.requestList2);
        /*LinearLayout requestList3 = findViewById(R.id.requestList3);
        LinearLayout requestList4 = findViewById(R.id.requestList4);
        LinearLayout requestList5 = findViewById(R.id.requestList5);*/
        LinearLayout[] reqArray = {requestList0, requestList1, requestList2};//, requestList3, requestList4,
            // requestList5};

        for (int i = 0; i < 3; i++) {
            JsonObject request = requests.get(i).getAsJsonObject();
            View requestChunk = getLayoutInflater().inflate(R.layout.chunk_request,
                    reqArray[i], false);
            // Declares 2 TextViews and 1 Button
            Button acceptRequest = requestChunk.findViewById(R.id.acceptRequest);
            TextView personalInfo = requestChunk.findViewById(R.id.personalInfo);
            TextView sessionInfo = requestChunk.findViewById(R.id.sessionInfo);
            // Adds information to TextView
            personalInfo.setText(request.get("Personal_Info").getAsString());
            sessionInfo.setText(request.get("Session_Info").getAsString());
            // Adds button functionality
            acceptRequest.setOnClickListener(args -> {
                // Remove request
            });
            // Final step: adds info
            reqArray[i].addView(requestChunk);
        }
    }
}
