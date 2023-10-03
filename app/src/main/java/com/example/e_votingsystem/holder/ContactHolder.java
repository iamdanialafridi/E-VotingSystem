package com.example.e_votingsystem.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_votingsystem.R;
import com.example.e_votingsystem.model.Contact;

import java.util.List;

public class ContactHolder extends RecyclerView.Adapter<ContactHolder.ViewContact>{
List<Contact> contactList;

    public ContactHolder(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ViewContact onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_contact_row, parent, false);
        return new ViewContact(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewContact holder, int position) {
Contact contact= contactList.get(position);
holder.name.setText(contact.getName());
holder.suggestion.setText(contact.getSuggestion());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    class ViewContact extends RecyclerView.ViewHolder {
        TextView name,suggestion;
        public ViewContact(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txtContactName);
            suggestion = itemView.findViewById(R.id.txtContactSuggestion);
        }
    }
}
