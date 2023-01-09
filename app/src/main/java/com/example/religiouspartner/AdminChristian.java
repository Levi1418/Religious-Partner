package com.example.religiouspartner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminChristian extends AppCompatActivity {
    private Button marriageC, landC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_christian);
        getSupportActionBar().setTitle("Admin-Christian");

        //here marriagei means marriage id of ADMIN MARRIAGE
        //here landi means land of ADMIN LAND
        marriageC = findViewById(R.id.marriageC);
        landC = findViewById(R.id.LandC);

        marriageC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intMarriageChristian = new Intent(AdminChristian.this,AdminMarriageChristian.class);
                startActivity(intMarriageChristian);
            }
        });
        landC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intChristianLand = new Intent(AdminChristian.this,AdminLandLawChristian.class);
                startActivity(intChristianLand);
            }
        });
    }
}