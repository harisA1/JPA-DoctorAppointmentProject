package com.example.demo.objectclasses;

import javax.persistence.*;

@Entity
public class Patient {

    @Id
    String amka;
    String name;
    String surname;

    //default constructor
    public Patient() {
    }

    public Patient(String n, String s, String a){
        this.name=n;
        this.surname=s;
        this.amka=a;
    }

    //getters for the patient variables
    public String getAmka() {
        return amka;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    //setters for the patient variables
    public void setAmka(String amka) {this.amka = amka;}
    public void setName(String name) {this.name = name;}
    public void setSurname(String surname) {this.surname = surname;}












}