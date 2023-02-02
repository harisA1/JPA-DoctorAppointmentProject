package com.example.demo.objectclasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Timeslot {
    @Id
    String timeslotID;
    String date;
    String start;
    String end;

    //Timeslots has many-to-one relationships with doctors AND vac centers
    //@JsonIgnoreProperties necessary to avoid stack overflow on GET requests
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name="doctor_amka")
    @JsonIgnoreProperties("timeslots")
    private Doctor doctor;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name="vc_name")
    private VaccinationCenter vaccinationCenter;

    //default constructor
    public Timeslot() {
    }

    //calculates end time to +20 mins from start
    public String calcEndTime(String start){
        // Split the time string into hours, minutes
        String[] parts = start.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        if (minutes == 40) {
            hours = hours +1;
            minutes=0;
        }else{
            minutes = minutes + 20;

        }
        String end=String.format("%02d:%02d", hours, minutes);
        return end;

    }

    //constructor
    public Timeslot(String d , String s) {
        this.date=d;
        this.start=s;
        String temp = d + s;
        this.timeslotID = temp.replaceAll("[^0-9]", "");
        this.end=calcEndTime(s);
    }
    //getters for timeslot variables
    public String getDate() {
        return date;
    }
    public String getStart() {
        return start;
    }
    public String getTimeslotID() {
        timeslotID =(date+start).replaceAll("[^0-9]", "");
        return timeslotID;}
    public String getEnd() {
        end =calcEndTime(start);
        return end;}
    //setters for timeslot variables
    public void setDate(String date) {this.date = date;}
    public void setStart(String start) {this.start = start;}
    public void setEnd(String end) {this.end = end;}
    public void setTimeslotID(String timeslotID) {this.timeslotID = timeslotID;}




    //getters for doctor and vaccinationcenter
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor d) {this.doctor=d;}

    public VaccinationCenter getVaccinationCenter() {return vaccinationCenter;}
    //setters for doctor and vaccinationcenter
    public void setVaccinationCenter(VaccinationCenter vc) {this.vaccinationCenter=vc;}











}
