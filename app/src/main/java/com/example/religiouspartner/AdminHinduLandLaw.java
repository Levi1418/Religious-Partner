package com.example.religiouspartner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminHinduLandLaw extends AppCompatActivity {

    EditText infoLLhindu;
    Button binserthinduLL, bviewhinduLL, bexithinduLL;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_hindu_land_law);
        getSupportActionBar().setTitle("Admin-Hindu-Land Law");

        infoLLhindu = findViewById(R.id.infoLLhindu);
        binserthinduLL = findViewById(R.id.inserthinduLL);
        bviewhinduLL = findViewById(R.id.viewhinduLL);
        bexithinduLL = findViewById(R.id.exithinduLL);

        db = openOrCreateDatabase("Mydb",MODE_PRIVATE,null);
        try {
            db.execSQL("create table if not exists InfosLandLawHindu (Information varchar(1000))");
            Toast.makeText(getApplicationContext(), "Table Created", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Table creation failed ", Toast.LENGTH_SHORT).show();
        }
        binserthinduLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = infoLLhindu.getText().toString();
                String insertQuery = "insert into InfosLandLawHindu values('"+info+"');";

                try {
                    db.execSQL(insertQuery);
                    Toast.makeText(getApplicationContext(), "row inserted", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "row insertion failed", Toast.LENGTH_SHORT).show();
                }

            }
        });

        bviewhinduLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intVhinduLL = new Intent(getApplicationContext(),HinduLandLawRecords.class);
                startActivity(intVhinduLL);
                finish();
            }
        });

        bexithinduLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { System.exit(0);
            }
        });
    }
}