package com.example.religiouspartner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminLand extends AppCompatActivity {

    private Button islamA, christianA, hinduA, buddhistA,homebt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_land);
        getSupportActionBar().setTitle("Admin Section");

        islamA = findViewById(R.id.IslamA);
        christianA = findViewById(R.id.ChristianA);
        hinduA = findViewById(R.id.HinduA);
        buddhistA= findViewById(R.id.BuddhistA);
        homebt =findViewById(R.id.homebt);

        islamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent islamA = new Intent(AdminLand.this,AdminIslam.class);
                startActivity(islamA);
            }
        });

        christianA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent christianA = new Intent(AdminLand.this,AdminChristian.class);
                startActivity(christianA);
            }
        });

        hinduA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hinduA = new Intent(AdminLand.this,AdminHindu.class);
                startActivity(hinduA);
            }
        });

        buddhistA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buddhistA = new Intent(AdminLand.this,AdminBuddhist.class);
                startActivity(buddhistA);
            }
        });

        homebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeBT = new Intent(AdminLand.this,MainActivity.class);
                startActivity(homeBT);
            }
        });
    }
}