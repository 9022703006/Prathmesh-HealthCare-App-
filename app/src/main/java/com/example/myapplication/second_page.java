package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.GridLayout;

import android.os.Bundle;
import android.widget.Toast;

public class second_page extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        CardView Home = findViewById(R.id.home);
        CardView bymedicen = findViewById(R.id.bymedinice);
        CardView findDoctor = findViewById(R.id.find_doctor);
        CardView Health = findViewById(R.id.Health);
        CardView Order = findViewById(R.id.order);
        CardView login = findViewById(R.id.logout);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(second_page.this, "Successfully Logout...!", Toast.LENGTH_SHORT).show();
                startActivities(new Intent[]{new Intent(second_page.this,MainActivity.class)});
            }
        });

        findDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new Intent(second_page.this,Thried_find_doctor.class)});
            }
        });
    }
}