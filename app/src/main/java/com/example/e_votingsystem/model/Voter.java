package com.example.e_votingsystem.model;

public class Voter {
    String id,Name, FatherName, Address, Gender, Phone,Cnic;


    public Voter() {
    }

    public Voter(String id, String name, String fatherName, String address, String gender, String phone, String cnic) {
        this.id = id;
        Name = name;
        FatherName = fatherName;
        Address = address;
        Gender = gender;
        Phone = phone;
        Cnic = cnic;
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

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String fatherName) {
        FatherName = fatherName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getCnic() {
        return Cnic;
    }

    public void setCnic(String cnic) {
        Cnic = cnic;
    }
}
