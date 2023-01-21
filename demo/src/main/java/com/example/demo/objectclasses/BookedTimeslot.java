package com.example.demo.objectclasses;

public class BookedTimeslot {

    public Timeslot timeslot;
    public Patient patient;

    public BookedTimeslot(Timeslot timeslot, Patient patient) {
        this.timeslot = timeslot;
        this.patient = patient;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    public Patient getPatient() {
        return patient;
    }


}
