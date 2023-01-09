package com.example.religiouspartner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn1, btn2,  btn3, btn4, btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Religious Partner");

        btn1 =findViewById(R.id.Islam);
        btn2 =findViewById(R.id.Christian);
        btn3 =findViewById(R.id.Hindu);
        btn4 =findViewById(R.id.Buddhist);
        btn5 =findViewById(R.id.admin);
        //btn1 =findViewById(R.id.Islam);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 = new Intent(MainActivity.this,Islam.class);
                startActivity(int1);
                finish();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int2 = new Intent(MainActivity.this,Christian.class);
                startActivity(int2);
                finish();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int3 = new Intent(MainActivity.this,Hindu.class);
                startActivity(int3);
                finish();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int4 = new Intent(MainActivity.this,Buddhist.class);
                startActivity(int4);
                finish();
            }
        });




        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int5 = new Intent(MainActivity.this,Admin.class);
                startActivity(int5);
                finish();
            }
        });

    }
}