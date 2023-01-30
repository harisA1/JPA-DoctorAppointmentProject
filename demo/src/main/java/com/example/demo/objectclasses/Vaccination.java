package com.example.demo.objectclasses;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="Vaccinations")

public class Vaccination {
    @Id
    private String vID;

    private String date;
    private String expdate;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "doctor_amka")
    private Doctor doctor;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "patient_amka")
    private Patient patient;

    //default constructor
    public Vaccination() {
    }
    public static String addSixMonths(String date) {
        String[] dateParts = date.split("/");
        int day = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]) - 1;
        int year = Integer.parseInt(dateParts[2]);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        calendar.add(Calendar.MONTH, 6);
        return calendar.get(Calendar.DAY_OF_MONTH) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.YEAR);
    }

    //constructor
    public Vaccination(String date) {
    this.vID=date + "3";
    this.date=date;
    this.expdate = addSixMonths(date);
    }

    public String getExpdate() {
        return expdate;
    }

    public void setExpdate(String date) {
        expdate=addSixMonths(date);
        this.expdate = expdate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getvID() {
        return vID;
    }

    public void setvID(String vID) {
        this.vID = vID;
    }
}