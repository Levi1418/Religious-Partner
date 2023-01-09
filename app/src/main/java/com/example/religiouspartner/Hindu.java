package com.example.religiouspartner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Hindu extends AppCompatActivity {

    private Button btn10, bnt11, backbthindu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hindu);
        getSupportActionBar().setTitle("Hindu");

        btn10 = findViewById(R.id.marriage3);
        bnt11 = findViewById(R.id.land3);
        backbthindu = findViewById(R.id.backbthindu);

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int10 = new Intent(Hindu.this,HinduMarriageRecords.class);
                startActivity(int10);
                finish();
            }
        });


        bnt11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int11 = new Intent(Hindu.this,HinduLandLawRecords.class);
                startActivity(int11);
                finish();
            }
        });

        backbthindu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backhindu = new Intent(Hindu.this,MainActivity.class);
                startActivity(backhindu);
                finish();
            }
        });
    }
}