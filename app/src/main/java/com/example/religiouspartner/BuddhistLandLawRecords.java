package com.example.religiouspartner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BuddhistLandLawRecords extends AppCompatActivity {

    TextView tLLBuddhist;
    Button nextLLBuddhist, prevLLBuddhist, BackBland;
    SQLiteDatabase db;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buddhist_land_law_records);
        getSupportActionBar().setTitle("Buddhist Land Laws");
        //recordMChristian = information of Marriage
        //nextMChristian = Admin Christian Marriage next
        tLLBuddhist = findViewById(R.id.recordLLBuddhist);
        nextLLBuddhist = findViewById(R.id.nextLLBuddhist);
        prevLLBuddhist = findViewById(R.id.prevLLBuddhist);
        BackBland = findViewById(R.id.BackBland);

        db= openOrCreateDatabase("Mydb", MODE_PRIVATE,null);
        Cursor cursorBLL = db.rawQuery("select * from InfosLandLawBuddhist",null);
        cursorBLL.moveToFirst();
        tLLBuddhist.setText(cursorBLL.getString(cursorBLL.getColumnIndex("Information")));

        BackBland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backBLand = new Intent(BuddhistLandLawRecords.this,Buddhist.class);
                startActivity(backBLand);
                finish();
            }
        });
        nextLLBuddhist.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View view) {
                try {
                    cursorBLL.moveToNext();
                    tLLBuddhist.setText(cursorBLL.getString(cursorBLL.getColumnIndex("Information")));

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "You are seeing the last record", Toast.LENGTH_SHORT).show();
                }
            }
        });
        prevLLBuddhist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    cursorBLL.moveToPrevious();
                    tLLBuddhist.setText(cursorBLL.getString(cursorBLL.getColumnIndex("Information")));
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"You are seeing the first record",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}