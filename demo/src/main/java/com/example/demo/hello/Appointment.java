package com.example.demo.hello;

import javax.persistence.*;
import java.util.List;


public class Appointment {



    Patient patient;

    Timeslot timeslot;


    String date;
    String start;
    String doctor;
    String doctorAmka;
    String vcname;
    String name;
    String surname;
    String amka;

    public Appointment() {
    }

    public Appointment (Patient p, Timeslot t){
        this.patient=p;
        this.timeslot=t;
        this.date=t.getDate();
        this.start=t.getStart();
        this.doctor=t.getDoctor();
        this.doctorAmka=t.getDoctorAmka();
        this.vcname=t.getVcname();
        this.name=p.getName();
        this.surname=p.getSurname();
        this.amka=p.getAmka();

    }

    public Patient getPatient() {
        return patient;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    //getters
    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getPatientName(){
        return patient.getName();
    }
    public String getPatientSurname(){
        return patient.getSurname();
    }
    public String getPatientAmka(){
        return patient.getAmka();
    }
    public String getTimeslotDate(){
        return timeslot.getDate();
    }
    public String getTimeslotStart(){
        return timeslot.getStart();
    }
    public String getTimeslotEnd(){
        return timeslot.getEndTime(timeslot.getStart());
    }
    public String getTimeslotDoctor(){
        return timeslot.getDoctor();
    }
    public String getTimeslotDoctorAmka(){
        return timeslot.getDoctorAmka();
    }
    public String getTimeslotVcname(){
        return timeslot.getVcname();
    }

}