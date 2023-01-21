package com.example.demo.objectclasses;

import com.example.demo.objectclasses.Doctor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vaccination_center")
public class VaccinationCenter {
    @Id
    String vcname;

    @ManyToMany(mappedBy = "vaccinationCenters")
    private Set<Doctor> doctors = new HashSet<Doctor>();

    //default constructor
    public VaccinationCenter() {
    }

    //constructor
    public VaccinationCenter(String n) {
        this.vcname=n;
    }

    //getter for vaccination center variables
    public String getVcname() {
        return vcname;
    }
    public void setVcname(String vcname) {this.vcname = vcname;}

}