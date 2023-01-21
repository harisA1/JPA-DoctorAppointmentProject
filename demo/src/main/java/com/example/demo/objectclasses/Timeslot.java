package com.example.demo.objectclasses;

import com.example.demo.objectclasses.Doctor;
import com.example.demo.objectclasses.Patient;

import javax.persistence.*;

@Entity
public class Timeslot {
    @Id
    String tid;
    String date;
    String start;
    String end;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="doctorname")
    private Doctor mappingdoctor;

    @OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="amka")
    private Patient mappingpatient;

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
        this.tid = temp.replaceAll("[^0-9]", "");
        this.end=calcEndTime(s);
    }
    //getters for timeslot variables
    public String getDate() {
        return date;
    }
    public String getStart() {
        return start;
    }
    public String getTid() {tid=(date+start).replaceAll("[^0-9]", "");
        return tid;}
    public String getEnd() {end =calcEndTime(start);
        return end;}
    //setters for timeslot variables
    public void setDate(String date) {this.date = date;}
    public void setStart(String start) {this.start = start;}
    public void setEnd(String end) {this.end = end;}
    public void setTid(String tid) {this.tid = tid;}




    //getters for mappingdoctor and mappingpatient
    public Doctor getDoctor() {
        return mappingdoctor;
    }
    public Patient getPatient() {
        return mappingpatient;
    }
    //setters for mappingdoctor and mappingpatient
    public void setDoctor(Doctor d) {
        this.mappingdoctor=d;
    }
    public void setPatient(Patient p) {
        this.mappingpatient=p;
    }









}
