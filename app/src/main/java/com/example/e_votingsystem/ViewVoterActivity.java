package com.example.e_votingsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.example.e_votingsystem.Util.FirebaseUtility;
import com.example.e_votingsystem.holder.ContactHolder;
import com.example.e_votingsystem.holder.VoterHolder;
import com.example.e_votingsystem.model.Contact;
import com.example.e_votingsystem.model.Voter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewVoterActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FirebaseUtility firebaseUtility;
    SearchView searchView;
    List<Voter> voterArrayList = new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_voter);
        recyclerView= findViewById(R.id.voterRv);
        searchView= findViewById(R.id.searhVoter);
        firebaseUtility= new FirebaseUtility(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        firebaseUtility.readWholeData("voter", new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                voterArrayList.clear();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Voter voter= dataSnapshot.getValue(Voter.class);
                    voterArrayList.add(voter);
                }
                VoterHolder voterHolder= new VoterHolder(voterArrayList);
                recyclerView.setAdapter(voterHolder);

                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        voterHolder.getFilter().filter(query);

                        return false;
                    }
                    @Override
                    public boolean onQueryTextChange(String newText) {
                        voterHolder.getFilter().filter(newText);

                        return false;
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ViewVoterActivity.this, "Database connection error", Toast.LENGTH_SHORT).show();

            }
        });
    }
}