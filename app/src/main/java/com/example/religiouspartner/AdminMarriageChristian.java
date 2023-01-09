package com.example.religiouspartner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminMarriageChristian extends AppCompatActivity {

    EditText infoMChristian;
    Button binsertCm, bviewCm, bexitCm;
    SQLiteDatabase db;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_marriage_christian);
        getSupportActionBar().setTitle("Admin-Christian Marriage");
        //binfoMChristian = Edit text box in admin marriage Christian
        //insertCm = Insert button in admin marriage christian
        infoMChristian = findViewById(R.id.infoMChristian);
        binsertCm = findViewById(R.id.insertCm);
        bviewCm = findViewById(R.id.viewCm);
        bexitCm = findViewById(R.id.exitCm);

        db = openOrCreateDatabase("Mydb",MODE_PRIVATE,null);
        try {
            db.execSQL("create table if not exists InfosMarriageChristian (Information varchar(1000))");
            Toast.makeText(getApplicationContext(), "Table Created", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Table creation failed ", Toast.LENGTH_SHORT).show();
        }
        binsertCm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = infoMChristian.getText().toString();
                String insertQuery = "insert into InfosMarriageChristian values('"+info+"');";

                try {
                    db.execSQL(insertQuery);
                    Toast.makeText(getApplicationContext(), "row inserted", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "row insertion failed", Toast.LENGTH_SHORT).show();
                }

            }
        });

        bviewCm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intVChristian = new Intent(getApplicationContext(),ChristianMarriageRecords.class);
                startActivity(intVChristian);
                finish();
            }
        });

        bexitCm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { System.exit(0);
            }
        });
    }
}