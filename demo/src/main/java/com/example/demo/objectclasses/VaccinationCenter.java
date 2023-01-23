package com.example.demo.objectclasses;

import com.example.demo.objectclasses.Doctor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vaccination_center")
public class VaccinationCenter {
    @Id
    String vcname;

    @OneToMany(mappedBy="date", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Timeslot> timeslots = new HashSet<Timeslot>();

    //default constructor
    public VaccinationCenter() {
    }
    //constructor
    public VaccinationCenter(String n) {
        this.vcname=n;
    }
    //getter for vaccination center variables
    public String getVcname() {
        return vcname;
    }
    public void setVcname(String vcname) {this.vcname = vcname;}

    //getters and setters for timeslots

    public void setTimeslots(Set<Timeslot> timeslots) {this.timeslots = timeslots;}

}