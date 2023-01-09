package com.example.religiouspartner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminIslam extends AppCompatActivity {
    private Button marriagei,Land1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_islam);
        getSupportActionBar().setTitle("Admin-Islam");

        //here marriagei means marriage id of ADMIN MARRIAGE
        //here landi means land of ADMIN LAND
        marriagei = findViewById(R.id.marriagei);
        Land1 = findViewById(R.id.Land1);

        marriagei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int15 = new Intent(AdminIslam.this,AdminMarriage.class);
                startActivity(int15);
            }
        });
        Land1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intLand = new Intent(AdminIslam.this,AdminLandLaws.class);
                startActivity(intLand);
            }
        });




    }
}