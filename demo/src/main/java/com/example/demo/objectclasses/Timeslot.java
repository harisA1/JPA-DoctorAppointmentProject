package com.example.demo.objectclasses;

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


    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name="doctor_amka")
    private Doctor doctor;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name="vc_name")
    private VaccinationCenter vaccinationCenter;

    //default constructor
    public Timeslot() {
    }

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




    //getters for mappingdoctor and mappingvaccinationcenter
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor d) {this.doctor=d;}

    public VaccinationCenter getVaccinationCenter() {return vaccinationCenter;}
    //setters for mappingdoctor and mappingvaccinationcenter
    public void setVaccinationCenter(VaccinationCenter vc) {this.vaccinationCenter=vc;}











}
