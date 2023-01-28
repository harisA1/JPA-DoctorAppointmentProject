package com.example.demo.objectclasses;

//supporting class used by the doctor to store a timeslot
//passes three entity objects through a POST request
//not an entity
public class AvailableTimeslotInVc {

    public Timeslot timeslot;
    public VaccinationCenter vaccinationcenter;
    public Doctor doctor;

    //constructor

    public AvailableTimeslotInVc(Timeslot timeslot, VaccinationCenter vc, Doctor doctor) {
        this.timeslot = timeslot;
        this.vaccinationcenter = vc;
        this.doctor = doctor;
    }

    //getters and setters
    public Timeslot getTimeslot() {return timeslot;}
    public void setTimeslot(Timeslot timeslot) {this.timeslot = timeslot;}

    public VaccinationCenter getVaccinationCenter() {return vaccinationcenter;}
    public void setVaccinationCenter(VaccinationCenter vc) {this.vaccinationcenter = vc;}

    public Doctor getDoctor() {return doctor;}
    public void setDoctor(Doctor doctor) {this.doctor = doctor;}
}
