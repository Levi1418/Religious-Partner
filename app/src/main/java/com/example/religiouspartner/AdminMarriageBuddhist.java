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

public class AdminMarriageBuddhist extends AppCompatActivity {
    EditText infoMBuddhist;
    Button binsertBuddhistM, bviewBuddhistM, bexitBuddhistM;
    SQLiteDatabase db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_marriage_buddhist);
        getSupportActionBar().setTitle("Admin-Buddhist Marriage");
        //binfoMChristian = Edit text box in admin marriage Christian
        //insertCm = Insert button in admin marriage christian
        infoMBuddhist = findViewById(R.id.infoMBuddhist);
        binsertBuddhistM = findViewById(R.id.insertBuddhistM);
        bviewBuddhistM = findViewById(R.id.viewBuddhistM);
        bexitBuddhistM = findViewById(R.id.exitBuddhistM);

        db = openOrCreateDatabase("Mydb",MODE_PRIVATE,null);
        try {
            db.execSQL("create table if not exists InfosMarriageBuddhist (Information varchar(1000))");
            Toast.makeText(getApplicationContext(), "Table Created", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Table creation failed ", Toast.LENGTH_SHORT).show();
        }
        binsertBuddhistM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = infoMBuddhist.getText().toString();
                String insertQuery = "insert into InfosMarriageBuddhist values('"+info+"');";

                try {
                    db.execSQL(insertQuery);
                    Toast.makeText(getApplicationContext(), "row inserted", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "row insertion failed", Toast.LENGTH_SHORT).show();
                }

            }
        });

        bviewBuddhistM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intVBuddhist = new Intent(getApplicationContext(),BuddhistMarriageRecords.class);
                startActivity(intVBuddhist);
                finish();
            }
        });

        bexitBuddhistM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { System.exit(0);
            }
        });


    }
}