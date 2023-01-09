package com.example.religiouspartner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Christian extends AppCompatActivity {

    private Button btn8, bnt9, backChristian;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_christian);
        getSupportActionBar().setTitle("Christian");

        btn8 = findViewById(R.id.marriage2);
        bnt9 = findViewById(R.id.land2);
        backChristian = findViewById(R.id.backChristian);

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int8 = new Intent(Christian.this,ChristianMarriageRecords.class);
                startActivity(int8);
                finish();
            }
        });


        bnt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int9 = new Intent(Christian.this,ChristianLandLawRecords.class);
                startActivity(int9);
                finish();
            }
        });

        backChristian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backChris = new Intent(Christian.this,MainActivity.class);
                startActivity(backChris);
                finish();
            }
        });


    }
}