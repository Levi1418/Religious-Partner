package com.example.religiouspartner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Buddhist extends AppCompatActivity {

    private Button btn12, bnt13, backbuddhist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buddhist);
        getSupportActionBar().setTitle("Buddhist");

        btn12 = findViewById(R.id.marriage4);
        bnt13 = findViewById(R.id.land4);
        backbuddhist = findViewById(R.id.backbuddhist);

        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int12 = new Intent(Buddhist.this,BuddhistMarriageRecords.class);
                startActivity(int12);
                finish();
            }
        });


        bnt13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int13 = new Intent(Buddhist.this,BuddhistLandLawRecords.class);
                startActivity(int13);
                finish();
            }
        });

        backbuddhist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backbud = new Intent(Buddhist.this,MainActivity.class);
                startActivity(backbud);
                finish();
            }
        });
    }
}