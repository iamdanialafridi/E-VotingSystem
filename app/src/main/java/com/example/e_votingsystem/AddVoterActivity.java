package com.example.e_votingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_votingsystem.Util.FirebaseUtility;
import com.example.e_votingsystem.model.Voter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class AddVoterActivity extends AppCompatActivity {
    EditText name,fname,phone,address,cnic;
    Spinner spinner;
    Button btnadd;

    DatabaseReference databaseReference;
    FirebaseUtility firebaseUtility;
    ProgressBar progressBar;
    String[] GenderList = {"Male","Female"};
    String Gender;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_voter);
        name= findViewById(R.id.inputVoterName);
        fname= findViewById(R.id.inputVoterFName);
        phone= findViewById(R.id.inputVoterPhone);
        address= findViewById(R.id.inputVoterAddr);
        cnic= findViewById(R.id.inputVoterCninc);
        spinner= findViewById(R.id.inputVoterGender);
        progressBar= findViewById(R.id.voterProgrssbar);
        btnadd= findViewById(R.id.btnRegisterVote);
        firebaseUtility = new FirebaseUtility(this);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("voter");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(AddVoterActivity.this, android.R.layout.simple_spinner_item, GenderList);

// Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Gender = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                btnadd.setVisibility(View.GONE);
                Toast.makeText(AddVoterActivity.this, ""+Gender, Toast.LENGTH_SHORT).show();
                String Name = name.getText().toString().trim();
                String Fname = fname.getText().toString().trim().toLowerCase();
                String Phone = phone.getText().toString().trim();
                String Address = address.getText().toString().trim();
                String Cnic = cnic.getText().toString().trim().toLowerCase();
                if (TextUtils.isEmpty(Name)) {
                    name.setError("Required");
                } else if (TextUtils.isEmpty(Fname)) {
                    fname.setError("Required");
                } else if (TextUtils.isEmpty(Phone)) {
                    phone.setError("Required");
                } else if (TextUtils.isEmpty(Address)) {
                    address.setError("Required");
                } else if (TextUtils.isEmpty(Cnic)) {
                    cnic.setError("Required");

                } else {
                    String key = databaseReference.push().getKey();
                    Voter voter= new Voter(key,Name,Fname,Address,Gender,Phone,Cnic);
                    firebaseUtility.createData("voter",key,voter,ViewVoterActivity.class,"Voter List Created");
btnadd.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

    }
}