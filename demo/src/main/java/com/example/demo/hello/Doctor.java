package com.example.vac;

public class Doctor {
    String name;
    String surname;
    String amka;

    public Doctor(String n,String s,String a){
        this.name=n;
        this.surname=s;
        this.amka=a;
    }

    public String getAmka() {
        return amka;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

}
