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

public class LandLawRecords extends AppCompatActivity {

    TextView tL;
    Button nextL, prevL, BackL;
    SQLiteDatabase db;

    @SuppressLint({"Range", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_law_records);
        getSupportActionBar().setTitle("Land Law");
        //recordM = information of Marriage
        //nextM = AdminMarriage next
        tL = findViewById(R.id.recordL);
        nextL = findViewById(R.id.nextL);
        prevL = findViewById(R.id.prevL);
        BackL = findViewById(R.id.BackL);

        db= openOrCreateDatabase("Mydb", MODE_PRIVATE,null);
        Cursor cursorL = db.rawQuery("select * from InfosLandLaw",null);
        cursorL.moveToFirst();
        tL.setText(cursorL.getString(cursorL.getColumnIndex("Information")));

        BackL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIL = new Intent(LandLawRecords.this,Islam.class);
                startActivity(backIL);
                finish();
            }
        });
        nextL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    cursorL.moveToNext();
                    tL.setText(cursorL.getString(cursorL.getColumnIndex("Information")));

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "You are seeing the last record", Toast.LENGTH_SHORT).show();
                }
            }
        });
        prevL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    cursorL.moveToPrevious();
                    tL.setText(cursorL.getString(cursorL.getColumnIndex("Information")));
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"You are seeing the first record",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}