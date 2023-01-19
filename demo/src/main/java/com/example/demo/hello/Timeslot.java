package com.example.demo.hello;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Timeslot {
    @Id
    String doctorAmka;

    String date;
    String start;
    String doctor;
    String vcname;

    public Timeslot() {
    }

    public Timeslot(String d , String s, String doctor, String vcname, String amka) {
        this.date=d;
        this.start=s;
        this.doctor=doctor;
        this.vcname=vcname;
        this.doctorAmka=amka;
    }

    public String getDate() {
        return date;
    }
    public String getDoctor() {
        return doctor;
    }

    public String getStart() {
        return start;
    }
    public String getEndTime(String start){
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
    public String getVcname() {
        return vcname;
    }

    public String getDoctorAmka() {
        return doctorAmka;
    }


}
