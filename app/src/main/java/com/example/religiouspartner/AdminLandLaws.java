package com.example.religiouspartner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLandLaws extends AppCompatActivity {

    EditText infoL;
    Button binsertL, bviewL, bexitL;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_land_laws);
        getSupportActionBar().setTitle("Land Laws");

        infoL = findViewById(R.id.infoL);
        binsertL = findViewById(R.id.insertL);
        bviewL = findViewById(R.id.viewL);
        bexitL = findViewById(R.id.exitL);

        db = openOrCreateDatabase("Mydb",MODE_PRIVATE,null);
        try {
            db.execSQL("create table if not exists InfosLandLaw (Information varchar(1000))");
            Toast.makeText(getApplicationContext(), "Table Created", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Table creation failed ", Toast.LENGTH_SHORT).show();
        }
        binsertL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = infoL.getText().toString();
                String insertQuery = "insert into InfosLandLaw values('"+info+"');";

                try {
                    db.execSQL(insertQuery);
                    Toast.makeText(getApplicationContext(), "row inserted", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "row insertion failed", Toast.LENGTH_SHORT).show();
                }

            }
        });

        bviewL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intViewLand = new Intent(getApplicationContext(),LandLawRecords.class);
                startActivity(intViewLand);
                finish();
            }
        });

        bexitL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { System.exit(0);
            }
        });



    }
}