package com.example.illinitutorapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
        LinearLayout requestList1 = findViewById(R.id.requestList1);
        LinearLayout requestList2 = findViewById(R.id.requestList2);
        LinearLayout requestList3 = findViewById(R.id.requestList3);
        LinearLayout requestList4 = findViewById(R.id.requestList4);
        LinearLayout requestList5 = findViewById(R.id.requestList5);
        LinearLayout requestList6 = findViewById(R.id.requestList6);
        LinearLayout requestList7 = findViewById(R.id.requestList7);
        LinearLayout requestList8 = findViewById(R.id.requestList8);
        LinearLayout requestList9 = findViewById(R.id.requestList9);
        LinearLayout requestList10 = findViewById(R.id.requestList10);
        LinearLayout requestList11 = findViewById(R.id.requestList11);
        LinearLayout requestList12 = findViewById(R.id.requestList12);
        LinearLayout requestList13 = findViewById(R.id.requestList13);
        LinearLayout requestList14 = findViewById(R.id.requestList14);
        LinearLayout requestList15 = findViewById(R.id.requestList15);
        LinearLayout requestList16 = findViewById(R.id.requestList16);
        LinearLayout requestList17 = findViewById(R.id.requestList17);
        LinearLayout requestList18 = findViewById(R.id.requestList18);
        LinearLayout requestList19 = findViewById(R.id.requestList19);
        LinearLayout requestList20 = findViewById(R.id.requestList20);
        LinearLayout[] reqArray = {requestList1, requestList2, requestList3, requestList4, requestList5,
                    requestList6, requestList7, requestList8, requestList9, requestList10, requestList11,
                    requestList12, requestList13, requestList14, requestList15, requestList16, requestList17, requestList18,
                    requestList19, requestList20};

        for (int i = 0; i < requests.size(); i++) {
            JsonObject request = requests.get(i).getAsJsonObject();
            if (request.get("Id").getAsInt() != i) {
                continue;
            }
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
            final int y = request.get("Id").getAsInt();
            acceptRequest.setOnClickListener(args -> {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setCancelable(true);
                builder.setTitle("Contact your student!");
                builder.setMessage(request.get("Personal_Info").getAsString() + " " +
                        request.get("Session_Info").getAsString() + "\nGo back to RequestForm Screen to update list");
                builder.show();
                // Remove request
                RequestForm.deleteData(y);
                requests.remove(request);
                // Updates list
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms
                        startActivity(new Intent(RequestList.this, RequestForm.class));
                    }
                }, 5000);
            });
            // Final step: adds info
            reqArray[i].addView(requestChunk);
        }
    }
}
