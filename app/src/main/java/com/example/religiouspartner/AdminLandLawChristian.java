package com.example.religiouspartner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLandLawChristian extends AppCompatActivity {
    EditText infoLLChristian;
    Button binsertCLL, bviewCLL, bexitCLL;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_land_law_christian);
        getSupportActionBar().setTitle("Admin-Christian Land Law");
        //binfoMChristian = Edit text box in admin marriage Christian
        //insertCm = Insert button in admin marriage christian
        infoLLChristian = findViewById(R.id.infoLLChristian);
        binsertCLL = findViewById(R.id.insertCLL);
        bviewCLL = findViewById(R.id.viewCLL);
        bexitCLL = findViewById(R.id.exitCLL);

        db = openOrCreateDatabase("Mydb",MODE_PRIVATE,null);
        try {
            db.execSQL("create table if not exists InfosLandLawChristian (Information varchar(1000))");
            Toast.makeText(getApplicationContext(), "Table Created", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Table creation failed ", Toast.LENGTH_SHORT).show();
        }
        binsertCLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = infoLLChristian.getText().toString();
                String insertQuery = "insert into InfosLandLawChristian values('"+info+"');";

                try {
                    db.execSQL(insertQuery);
                    Toast.makeText(getApplicationContext(), "row inserted", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "row insertion failed", Toast.LENGTH_SHORT).show();
                }

            }
        });

        bviewCLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intVChristianLL = new Intent(getApplicationContext(),ChristianLandLawRecords.class);
                startActivity(intVChristianLL);
                finish();
            }
        });

        bexitCLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { System.exit(0);
            }
        });
    }
}