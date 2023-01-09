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

public class HinduLandLawRecords extends AppCompatActivity {

    TextView tLLHindu;
    Button nextLLHindu, prevLLHindu, BackHLand;
    SQLiteDatabase db;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hindu_land_law_records);
        getSupportActionBar().setTitle("Hindu Land Laws");

        tLLHindu = findViewById(R.id.recordLLHindu);
        nextLLHindu = findViewById(R.id.nextLLHindu);
        prevLLHindu = findViewById(R.id.prevLLHindu);
        BackHLand = findViewById(R.id.BackHLand);

        db= openOrCreateDatabase("Mydb", MODE_PRIVATE,null);
        Cursor cursorHLL = db.rawQuery("select * from InfosLandLawHindu",null);
        cursorHLL.moveToFirst();
        tLLHindu.setText(cursorHLL.getString(cursorHLL.getColumnIndex("Information")));

        BackHLand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backHinduLand = new Intent(HinduLandLawRecords.this,Hindu.class);
                startActivity(backHinduLand);
                finish();
            }
        });
        nextLLHindu.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View view) {
                try {
                    cursorHLL.moveToNext();
                    tLLHindu.setText(cursorHLL.getString(cursorHLL.getColumnIndex("Information")));

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "You are seeing the last record", Toast.LENGTH_SHORT).show();
                }
            }
        });
        prevLLHindu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    cursorHLL.moveToPrevious();
                    tLLHindu.setText(cursorHLL.getString(cursorHLL.getColumnIndex("Information")));
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"You are seeing the first record",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}