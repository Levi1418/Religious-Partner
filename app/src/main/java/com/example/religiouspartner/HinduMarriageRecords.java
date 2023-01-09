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

public class HinduMarriageRecords extends AppCompatActivity {

    TextView tMHindu;
    Button nextMHindu, prevMHindu, BackHmarriage;
    SQLiteDatabase db;

    @SuppressLint({"MissingInflatedId", "Range"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hindu_marriage_records);
        getSupportActionBar().setTitle("Hindu Marriage");

        tMHindu = findViewById(R.id.recordMHindu);
        nextMHindu = findViewById(R.id.nextMHindu);
        prevMHindu = findViewById(R.id.prevMHindu);
        BackHmarriage = findViewById(R.id.BackHmarriage);

        db= openOrCreateDatabase("Mydb", MODE_PRIVATE,null);
        Cursor cursorHM = db.rawQuery("select * from InfosMarriageHindu",null);
        cursorHM.moveToFirst();
        tMHindu.setText(cursorHM.getString(cursorHM.getColumnIndex("Information")));

        BackHmarriage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backhmarriage = new Intent(HinduMarriageRecords.this,Hindu.class);
                startActivity(backhmarriage);
                finish();
            }
        });
        nextMHindu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    cursorHM.moveToNext();
                    tMHindu.setText(cursorHM.getString(cursorHM.getColumnIndex("Information")));

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "You are seeing the last record", Toast.LENGTH_SHORT).show();
                }
            }
        });
        prevMHindu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    cursorHM.moveToPrevious();
                    tMHindu.setText(cursorHM.getString(cursorHM.getColumnIndex("Information")));
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"You are seeing the first record",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}