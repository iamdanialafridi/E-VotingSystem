package com.example.e_votingsystem.model;

public class Contact {
    String id,Name,Suggestion;

    public Contact() {
    }

    public Contact(String id, String name, String suggestion) {
        this.id = id;
        Name = name;
        Suggestion = suggestion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSuggestion() {
        return Suggestion;
    }

    public void setSuggestion(String suggestion) {
        Suggestion = suggestion;
    }
}
