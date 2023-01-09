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

public class AdminHinduMarriage extends AppCompatActivity {

    EditText infoMhindu;
    Button binserthinduM, bviewhinduM, bexithinduM;
    SQLiteDatabase db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_hindu_marriage);
        getSupportActionBar().setTitle("Admin-Hindu-Marriage");

        infoMhindu = findViewById(R.id.infoMhindu);
        binserthinduM = findViewById(R.id.inserthinduM);
        bviewhinduM = findViewById(R.id.viewhinduM);
        bexithinduM = findViewById(R.id.exithinduM);

        db = openOrCreateDatabase("Mydb",MODE_PRIVATE,null);
        try {
            db.execSQL("create table if not exists InfosMarriageHindu (Information varchar(1000))");
            Toast.makeText(getApplicationContext(), "Table Created", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Table creation failed ", Toast.LENGTH_SHORT).show();
        }
        binserthinduM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = infoMhindu.getText().toString();
                String insertQuery = "insert into InfosMarriageHindu values('"+info+"');";

                try {
                    db.execSQL(insertQuery);
                    Toast.makeText(getApplicationContext(), "row inserted", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "row insertion failed", Toast.LENGTH_SHORT).show();
                }

            }
        });

        bviewhinduM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intVhinduM = new Intent(getApplicationContext(),HinduMarriageRecords.class);
                startActivity(intVhinduM);
                finish();
            }
        });

        bexithinduM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { System.exit(0);
            }
        });
    }
}