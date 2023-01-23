package com.example.demo.objectclasses;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    String damka;
    String doctorname;

    @OneToMany(mappedBy="timeslotID", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Timeslot> timeslots= new ArrayList<Timeslot>();

    //default constructor
    public Doctor() {
    }
    //constructor
    public Doctor(String doctorAmka,String doctorName){
        this.damka=doctorAmka;
        this.doctorname=doctorName;

    }
    //getter for doctor variables
    public String getDamka() {
        return damka;
    }
    public String getDoctorname() {
        return doctorname;
    }
    //setter for doctor variables
    public void setDamka(String damka) {this.damka = damka;}
    public void setDoctorname(String doctorname) {this.doctorname = doctorname;}

    //getters and setters for timeslots



    public void setTimeslots(List<Timeslot> timeslots) {this.timeslots = timeslots;}

    //add timeslot
    public void addTimeslot(Timeslot t) {timeslots.add(t);}



}
