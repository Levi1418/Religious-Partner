package com.example.religiouspartner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin extends AppCompatActivity {

    private EditText edtxt;
    private EditText edtxtP;
    private Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        getSupportActionBar().setTitle("Login Page");

        edtxt = findViewById(R.id.Ename);
        edtxtP = findViewById(R.id.Epass);
        loginButton = findViewById(R.id.login);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtxt.getText().toString().equals("") &&
                        edtxtP.getText().toString().equals("")){
                    Intent intent= new Intent(Admin.this,AdminLand.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(Admin.this,"Welcome",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(Admin.this,"Wrong Credentials",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}