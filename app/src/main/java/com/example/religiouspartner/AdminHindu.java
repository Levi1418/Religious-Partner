package com.example.religiouspartner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminHindu extends AppCompatActivity {
    private Button marriagehindu, Landhindu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_hindu);
        getSupportActionBar().setTitle("Hindu");

        marriagehindu = findViewById(R.id.marriagehindu);
        Landhindu = findViewById(R.id.Landhindu);

        marriagehindu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intmarriagehindu = new Intent(AdminHindu.this,AdminHinduMarriage.class);
                startActivity(intmarriagehindu);
            }
        });
        Landhindu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intLandhindu = new Intent(AdminHindu.this,AdminHinduLandLaw.class);
                startActivity(intLandhindu);
            }
        });
    }
}