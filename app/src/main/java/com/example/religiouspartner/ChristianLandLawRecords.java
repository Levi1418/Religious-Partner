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

public class ChristianLandLawRecords extends AppCompatActivity {

    TextView tLLChristian;
    Button nextLLChristian, prevLLChristian, BackLand;
    SQLiteDatabase db;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_christian_land_law_records);
        getSupportActionBar().setTitle("Christian Land Laws");
        //recordMChristian = information of Marriage
        //nextMChristian = Admin Christian Marriage next
        tLLChristian = findViewById(R.id.recordLLChristian);
        nextLLChristian = findViewById(R.id.nextLLChristian);
        prevLLChristian = findViewById(R.id.prevLLChristian);
        BackLand = findViewById(R.id.BackCland);

        db= openOrCreateDatabase("Mydb", MODE_PRIVATE,null);
        Cursor cursorCLL = db.rawQuery("select * from InfosLandLawChristian",null);
        cursorCLL.moveToFirst();
        tLLChristian.setText(cursorCLL.getString(cursorCLL.getColumnIndex("Information")));

        BackLand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backChrisLand = new Intent(ChristianLandLawRecords.this,Christian.class);
                startActivity(backChrisLand);
                finish();
            }
        });
        nextLLChristian.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View view) {
                try {
                    cursorCLL.moveToNext();
                    tLLChristian.setText(cursorCLL.getString(cursorCLL.getColumnIndex("Information")));

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "You are seeing the last record", Toast.LENGTH_SHORT).show();
                }
            }
        });
        prevLLChristian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    cursorCLL.moveToPrevious();
                    tLLChristian.setText(cursorCLL.getString(cursorCLL.getColumnIndex("Information")));
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"You are seeing the first record",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}