package com.example.demo.objectclasses;

import javax.persistence.*;

@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    private String appointmentID;

    //Appointment has one to one relationships with timeslot and patient
    @OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="timeslotID")
    private Timeslot timeslot;

    @OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="amka")
    private Patient patient;


    //constructor
    public Appointment() {

        this.appointmentID="0";
    }

    //getters for the appointment variables
    public String getAppointmentID() {
        appointmentID=timeslot.getDoctor().getDamka()+patient.getAmka();
        return appointmentID;}

    public Timeslot getTimeslot() {return timeslot;}
    public Patient getPatient() {return patient;}
    public String getAmka() {
        String Amka=patient.getAmka();
        return Amka;}

    //setters for the appointment variables
    public void setAppointmentID(String appointmentID) {this.appointmentID = appointmentID;}
    public void setTimeslot(Timeslot timeslot) {this.timeslot = timeslot;}
    public void setPatient(Patient patient) {this.patient = patient;}


}