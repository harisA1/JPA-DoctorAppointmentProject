package com.example.demo.objectclasses;

import javax.persistence.*;

@Entity
@Table(name="Vaccinations")

public class Vaccination {
    @Id
    private String expdate;

    @ManyToOne
    @JoinColumn(name="doctor_amka")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name="patient_amka")
    private Patient patient;

    //default constructor
    public Vaccination(){}

    //constructor
    public Vaccination(Doctor d,Patient p) {
        this.doctor=d;
        this.patient=p;
        this.expdate="6 months later";
    }

    public String getExpdate() {
        return expdate;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }
}
