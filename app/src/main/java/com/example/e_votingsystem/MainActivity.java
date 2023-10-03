package com.example.e_votingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.e_votingsystem.admin.AdminLoginActivity;

public class MainActivity extends AppCompatActivity {
Button btnAdmin,btnContact,btnViewContactUs,btnAddVoter,btnViewVoter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdmin= findViewById(R.id.btnAdmin);
        btnContact= findViewById(R.id.btnContactUs);
        btnViewContactUs= findViewById(R.id.btnViewContactUs);
        btnAddVoter= findViewById(R.id.btnADDVoter);
        btnViewVoter= findViewById(R.id.btnViewVoter);
        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AdminLoginActivity.class));
            }
        });
        btnViewVoter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ViewVoterActivity.class));
            }
        });
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ContactUsActivity.class));
            }
        });
        btnViewContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ViewContactActivity.class));
            }
        });

        btnAddVoter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddVoterActivity.class));
            }
        });
    }
}