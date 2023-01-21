package com.example.demo.objectclasses;

public class AvailableTimeslot {

    public Timeslot timeslot;
    public Doctor doctor;

    public AvailableTimeslot(Timeslot timeslot, Doctor doctor) {
        this.timeslot = timeslot;
        this.doctor = doctor;
    }

    public Timeslot getTimeslot() {return timeslot;}
    public void setTimeslot(Timeslot timeslot) {this.timeslot = timeslot;}

    public Doctor getDoctor() {return doctor;}
    public void setDoctor(Doctor doctor) {this.doctor = doctor;}


}
