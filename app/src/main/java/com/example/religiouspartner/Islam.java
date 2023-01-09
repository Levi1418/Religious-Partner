package com.example.religiouspartner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Islam extends AppCompatActivity {

    private Button btn6, bnt7,backbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_islam);
        getSupportActionBar().setTitle("Islam");

        btn6 = findViewById(R.id.marriage);
        bnt7 = findViewById(R.id.land);
        backbt = findViewById(R.id.backbt);

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int6 = new Intent(Islam.this,MarriageRecords.class);
                startActivity(int6);
                finish();
            }
        });


        bnt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int7 = new Intent(Islam.this,LandLawRecords.class);
                startActivity(int7);
                finish();
            }
        });
        backbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intBack = new Intent(Islam.this,MainActivity.class);
                startActivity(intBack);
                finish();
            }
        });
    }
}