package com.example.e_votingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.e_votingsystem.Util.FirebaseUtility;
import com.example.e_votingsystem.model.Contact;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ContactUsActivity extends AppCompatActivity {
EditText name,suggestion;
Button btnContact;
FirebaseUtility firebaseUtility;
        DatabaseReference databaseReference;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        name=findViewById(R.id.inputContactName);
        suggestion=findViewById(R.id.inputContactSuggestion);
        btnContact=findViewById(R.id.btnSendContact);
firebaseUtility = new FirebaseUtility(this);
databaseReference= FirebaseDatabase.getInstance().getReference().child("contactus");

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Name = name.getText().toString().trim();
                String Suggestion = suggestion.getText().toString().trim();
                if(TextUtils.isEmpty(Name)){
                    name.setError("Required");
                } else if(TextUtils.isEmpty(Suggestion)){
                    suggestion.setError("Required");
                } else {
String key = databaseReference.push().getKey();
                    Contact contact= new Contact(key,Name,Suggestion);
                    firebaseUtility.createData("contactus",key,contact,ViewContactActivity.class,"Suggestion Created");
                }
            }
        });
    }
}