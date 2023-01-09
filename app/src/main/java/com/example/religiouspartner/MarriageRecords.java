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

public class MarriageRecords extends AppCompatActivity {

    TextView tM;
    Button nextM, prevM, BackM;
    SQLiteDatabase db;

    @SuppressLint({"Range", "MissingInflatedId", "UseSupportActionBar"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marriage_records);
        getSupportActionBar().setTitle("Marriage");
        //recordM = information of Marriage
        //nextM = AdminMarriage next
        tM = findViewById(R.id.recordM);
        nextM = findViewById(R.id.nextM);
        prevM = findViewById(R.id.prevM);
        BackM = findViewById(R.id.BackM);

        db= openOrCreateDatabase("Mydb", MODE_PRIVATE,null);
        Cursor cursor = db.rawQuery("select * from InfosMarriageIslam1",null);
        cursor.moveToFirst();
        tM.setText(cursor.getString(cursor.getColumnIndex("Information")));

        BackM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIa = new Intent(MarriageRecords.this,Islam.class);
                startActivity(backIa);
                finish();
            }
        });
        nextM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    cursor.moveToNext();
                    tM.setText(cursor.getString(cursor.getColumnIndex("Information")));

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "You are seeing the last record", Toast.LENGTH_SHORT).show();
                }
            }
        });
        prevM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    cursor.moveToPrevious();
                    tM.setText(cursor.getString(cursor.getColumnIndex("Information")));
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"You are seeing the first record",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}