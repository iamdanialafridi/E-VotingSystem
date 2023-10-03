package com.example.e_votingsystem.holder;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_votingsystem.R;
import com.example.e_votingsystem.model.Contact;
import com.example.e_votingsystem.model.Voter;

import java.util.ArrayList;
import java.util.List;

public class VoterHolder extends RecyclerView.Adapter<VoterHolder.ViewVoter> implements Filterable {
List<Voter> voterList;
List<Voter> FullvoterList;


    public VoterHolder(List<Voter> voterList) {
        this.voterList = voterList;
        FullvoterList = new ArrayList<>(voterList);

    }

    @NonNull
    @Override
    public ViewVoter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_voter_row, parent, false);
        return new ViewVoter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewVoter holder, int position) {
Voter voter= voterList.get(position);
holder.name.setText(voter.getName());
holder.fname.setText(voter.getFatherName());
holder.phone.setText(voter.getPhone());
holder.address.setText(voter.getAddress());
holder.cnic.setText(voter.getCnic());
holder.gender.setText(voter.getGender());
    }

    @Override
    public int getItemCount() {
        return voterList.size();
    }

    @Override
    public Filter getFilter() {
        return VoterList_Filter;
    }
    private Filter VoterList_Filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Voter> filteredList =new ArrayList<>();
            if (constraint == null|| constraint.length()==0){

                filteredList.addAll(FullvoterList);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Voter item : FullvoterList){
                    if (item.getName().toLowerCase().contains(filterPattern) || item.getName().toUpperCase().contains(filterPattern)){

                        filteredList.add(item);
                    }
                }
            }

            FilterResults  results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @SuppressLint("NotifyDataSetChanged")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            voterList.clear();
            voterList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    class ViewVoter extends RecyclerView.ViewHolder {
        TextView   name,fname,phone,address,cnic,gender;
        public ViewVoter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txtVoterName);
            fname = itemView.findViewById(R.id.txtVoterFname);
            phone = itemView.findViewById(R.id.txtVoterPhone);
            address = itemView.findViewById(R.id.txtVoterFAddr);
            cnic = itemView.findViewById(R.id.txtVoterNic);
            gender = itemView.findViewById(R.id.txtVoterGender);
        }
    }
}
