package com.example.e_votingsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.e_votingsystem.Util.FirebaseUtility;
import com.example.e_votingsystem.holder.ContactHolder;
import com.example.e_votingsystem.model.Contact;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewContactActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FirebaseUtility firebaseUtility;
    List<Contact> contactList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contact);
        recyclerView= findViewById(R.id.contactRv);
        firebaseUtility= new FirebaseUtility(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        firebaseUtility.readWholeData("contactus", new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                contactList.clear();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Contact contact= dataSnapshot.getValue(Contact.class);
                    contactList.add(contact);
                }
                ContactHolder contactHolder= new ContactHolder(contactList);
                recyclerView.setAdapter(contactHolder);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ViewContactActivity.this, "Database connection error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}