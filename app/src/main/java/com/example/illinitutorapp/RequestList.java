package com.example.illinitutorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
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
        LinearLayout requestList5 = findViewById(R.id.requestList5);
        LinearLayout requestList6 = findViewById(R.id.requestList6);
        LinearLayout requestList7 = findViewById(R.id.requestList7);
        LinearLayout requestList8 = findViewById(R.id.requestList8);
        LinearLayout[] reqArray = {requestList8, requestList7, requestList6, requestList5};

        for (int i = 3; i >= 0; i--) {
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
            final int y = i;
            acceptRequest.setOnClickListener(args -> {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setCancelable(true);
                builder.setTitle("Contact your student!");
                builder.setMessage(request.get("Personal_Info").getAsString() + " " +
                        request.get("Session_info").getAsString());
                builder.show();
                // Remove request
                RequestForm.deleteData(y);
                // Updates list
                startActivity(new Intent(this, RequestForm.class));
            });
            // Final step: adds info
            reqArray[i].addView(requestChunk);
        }
    }
}
