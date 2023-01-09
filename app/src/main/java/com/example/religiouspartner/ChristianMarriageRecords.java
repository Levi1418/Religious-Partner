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

public class ChristianMarriageRecords extends AppCompatActivity {
    TextView tMChristian;
    Button nextMChristian, prevMChristian, BackCmarriage;
    SQLiteDatabase db;

    @SuppressLint({"MissingInflatedId", "Range"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_christian_marriage_records);
        getSupportActionBar().setTitle("Christian Marriage");
        //recordMChristian = information of Marriage
        //nextMChristian = Admin Christian Marriage next
        tMChristian = findViewById(R.id.recordMChristian);
        nextMChristian = findViewById(R.id.nextMChristian);
        prevMChristian = findViewById(R.id.prevMChristian);
        BackCmarriage = findViewById(R.id.BackCmarriage);

        db= openOrCreateDatabase("Mydb", MODE_PRIVATE,null);
        Cursor cursorCM = db.rawQuery("select * from InfosMarriageChristian",null);
        cursorCM.moveToFirst();
        tMChristian.setText(cursorCM.getString(cursorCM.getColumnIndex("Information")));

        BackCmarriage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backcmarriage = new Intent(ChristianMarriageRecords.this,Christian.class);
                startActivity(backcmarriage);
                finish();
            }
        });
        nextMChristian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    cursorCM.moveToNext();
                    tMChristian.setText(cursorCM.getString(cursorCM.getColumnIndex("Information")));

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "You are seeing the last record", Toast.LENGTH_SHORT).show();
                }
            }
        });
        prevMChristian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    cursorCM.moveToPrevious();
                    tMChristian.setText(cursorCM.getString(cursorCM.getColumnIndex("Information")));
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"You are seeing the first record",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}