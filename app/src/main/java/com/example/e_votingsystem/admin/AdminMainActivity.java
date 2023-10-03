package com.example.e_votingsystem.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.e_votingsystem.R;

public class AdminMainActivity extends AppCompatActivity {
    SessionManager sessionManager;
    Button btnLogout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
        btnLogout= findViewById(R.id.btnLogoutAdmin);
        sessionManager= new SessionManager(this);
        sessionManager.checkLogin();
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManager.logoutUser();
                finish();
            }
        });
    }
}