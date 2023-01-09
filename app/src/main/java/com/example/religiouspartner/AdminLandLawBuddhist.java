package com.example.religiouspartner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLandLawBuddhist extends AppCompatActivity {

    EditText infoLLBuddhist;
    Button binsertBuddhistLL, bviewBuddhistLL, bexitBuddhistLL;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_land_law_buddhist);
        getSupportActionBar().setTitle("Admin-Buddhist-Land Law");
        infoLLBuddhist = findViewById(R.id.infoLLBuddhist);
        binsertBuddhistLL = findViewById(R.id.insertBuddhistLL);
        bviewBuddhistLL = findViewById(R.id.viewBuddhistLL);
        bexitBuddhistLL = findViewById(R.id.exitBuddhistLL);

        db = openOrCreateDatabase("Mydb",MODE_PRIVATE,null);
        try {
            db.execSQL("create table if not exists InfosLandLawBuddhist (Information varchar(1000))");
            Toast.makeText(getApplicationContext(), "Table Created", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Table creation failed ", Toast.LENGTH_SHORT).show();
        }
        binsertBuddhistLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = infoLLBuddhist.getText().toString();
                String insertQuery = "insert into InfosLandLawBuddhist values('"+info+"');";

                try {
                    db.execSQL(insertQuery);
                    Toast.makeText(getApplicationContext(), "row inserted", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "row insertion failed", Toast.LENGTH_SHORT).show();
                }

            }
        });

        bviewBuddhistLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intVBuddhistLL = new Intent(getApplicationContext(),BuddhistLandLawRecords.class);
                startActivity(intVBuddhistLL);
                finish();
            }
        });

        bexitBuddhistLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { System.exit(0);
            }
        });



    }
}