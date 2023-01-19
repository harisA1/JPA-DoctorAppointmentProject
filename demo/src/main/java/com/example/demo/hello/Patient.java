package com.example.demo.hello;

import javax.persistence.*;

@Entity
public class Patient {

    @Id
    String amka;


    String name;
    String surname;

    @OneToOne
    @JoinTable(name = "appointments")
    private Timeslot timeslot;

    public Patient() {
    }

    public Patient(String n, String s, String a){
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

    public Timeslot setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
        return timeslot;
    }
    //getter for timeslot
    public Timeslot getTimeslot(){
        return timeslot;
    }

    public String getDoctor(){
        return timeslot.getDoctor();
    }

    public String getVcname(){
        return timeslot.getVcname();
    }

    public String getDate(){
        return timeslot.getDate();
    }

    public String getStart(){
        return timeslot.getStart();
    }

    public String getDoctorAmka(){
        return timeslot.getDoctorAmka();
    }




}