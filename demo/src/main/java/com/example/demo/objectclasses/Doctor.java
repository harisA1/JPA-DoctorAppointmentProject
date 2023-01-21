package com.example.demo.objectclasses;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    String damka;
    String doctorname;

    @OneToMany(mappedBy="tid", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Timeslot> timeslots = new HashSet<Timeslot>();


    @ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="vcname")
    private Set<VaccinationCenter> vaccinationCenters = new HashSet<VaccinationCenter>();

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


    public Set<Timeslot> getTimeslots(Timeslot t) {
        return timeslots;
    }

    public void addVaccinationCenter(VaccinationCenter vc) {
        vaccinationCenters.add(vc);
    }

    public Set<VaccinationCenter> getVaccinationCenters() {
        return vaccinationCenters;
    }
}
