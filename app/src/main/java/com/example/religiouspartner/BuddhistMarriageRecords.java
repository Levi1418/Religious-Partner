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

public class BuddhistMarriageRecords extends AppCompatActivity {
    TextView tMBuddhist;
    Button nextMBuddhist, prevMBuddhist, BackBmarriage;
    SQLiteDatabase db;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buddhist_marriage_records);
        getSupportActionBar().setTitle("Buddhist Marriage");
        //recordMChristian = information of Marriage
        //nextMChristian = Admin Christian Marriage next
        tMBuddhist = findViewById(R.id.recordMBuddhist);
        nextMBuddhist = findViewById(R.id.nextMBuddhist);
        prevMBuddhist = findViewById(R.id.prevMBuddhist);
        BackBmarriage = findViewById(R.id.BackBmarriage);

        db= openOrCreateDatabase("Mydb", MODE_PRIVATE,null);
        Cursor cursorBM = db.rawQuery("select * from InfosMarriageBuddhist",null);
        cursorBM.moveToFirst();
        tMBuddhist.setText(cursorBM.getString(cursorBM.getColumnIndex("Information")));

        BackBmarriage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backBmarriage = new Intent(BuddhistMarriageRecords.this,Buddhist.class);
                startActivity(backBmarriage);
                finish();
            }
        });
        nextMBuddhist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    cursorBM.moveToNext();
                    tMBuddhist.setText(cursorBM.getString(cursorBM.getColumnIndex("Information")));

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "You are seeing the last record", Toast.LENGTH_SHORT).show();
                }
            }
        });
        prevMBuddhist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    cursorBM.moveToPrevious();
                    tMBuddhist.setText(cursorBM.getString(cursorBM.getColumnIndex("Information")));
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"You are seeing the first record",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}