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

public class AdminMarriage extends AppCompatActivity {

   EditText infoM;
   Button binsert, bview, bexit;
   SQLiteDatabase db;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_marriage);
        getSupportActionBar().setTitle("Admin-Marriage");
        //binfoM = Edit text box in admin marriage
        infoM = findViewById(R.id.infoM);
        binsert = findViewById(R.id.insert);
        bview = findViewById(R.id.view);
        bexit = findViewById(R.id.exit);

        db = openOrCreateDatabase("Mydb",MODE_PRIVATE,null);
       try {
           db.execSQL("create table if not exists InfosMarriageIslam1 (Information varchar(1000))");
           Toast.makeText(getApplicationContext(), "Table Created", Toast.LENGTH_SHORT).show();
       }catch (Exception e){
           Toast.makeText(getApplicationContext(), "Table creation failed ", Toast.LENGTH_SHORT).show();
       }

       binsert.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String info = infoM.getText().toString();
               String insertQuery = "insert into InfosMarriageIslam1 values('"+info+"');";

               try {
                   db.execSQL(insertQuery);
                   Toast.makeText(getApplicationContext(), "row inserted", Toast.LENGTH_SHORT).show();
               }catch (Exception e){
                   Toast.makeText(getApplicationContext(), "row insertion failed", Toast.LENGTH_SHORT).show();
               }

           }
       });

       bview.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intV = new Intent(getApplicationContext(),MarriageRecords.class);
               startActivity(intV);
               finish();
           }
       });

       bexit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) { System.exit(0);
           }
       });




    }
}