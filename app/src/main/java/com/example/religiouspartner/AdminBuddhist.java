package com.example.religiouspartner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminBuddhist extends AppCompatActivity {

    private Button marriageB, LandB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_buddhist);
        getSupportActionBar().setTitle("Admin-Buddhist");

        //here marriageB means marriage id of ADMIN MARRIAGE
        //here landB means land of ADMIN LAND
        marriageB = findViewById(R.id.marriageB);
        LandB = findViewById(R.id.LandB);

        marriageB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intMarriageChristian = new Intent(AdminBuddhist.this,AdminMarriageBuddhist.class);
                startActivity(intMarriageChristian);
            }
        });
        LandB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intChristianLand = new Intent(AdminBuddhist.this,AdminLandLawBuddhist.class);
                startActivity(intChristianLand);
            }
        });
    }
}