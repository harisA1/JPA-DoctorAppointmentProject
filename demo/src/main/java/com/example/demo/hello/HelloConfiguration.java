package com.example.demo.hello;

import com.example.demo.objectclasses.Doctor;
import com.example.demo.objectclasses.Patient;
import com.example.demo.objectclasses.Timeslot;
import com.example.demo.objectclasses.VaccinationCenter;
import org.springframework.boot.*;
import org.springframework.context.annotation.*;
import org.springframework.beans.factory.annotation.*;

@Configuration
public class HelloConfiguration implements CommandLineRunner {

    @Autowired
    private HelloService hs;

    @Override
    public void run(String... args) throws Exception {



        Timeslot timeslot1 = new Timeslot("24/04/2020", "10:00");
        Timeslot timeslot2 = new Timeslot("25/04/2020", "11:00");

        Patient patient1 = new Patient("Haris", "Ampas", "25089089");
        Patient patient2 = new Patient("Mihalis", "Koutsogiannis ", "7872631");

        Doctor doctor1 = new Doctor("Dr. House", "house123");
        Doctor doctor2 = new Doctor("Dr. Who", "who321");

        VaccinationCenter vc1 = new VaccinationCenter("Panepistimiako Nosokomeio");
        VaccinationCenter vc2 = new VaccinationCenter("Aghia Sophia");


        hs.addPatient( patient1 );
        hs.addPatient( patient2 );
        hs.addDoctor(doctor1);
        hs.addDoctor(doctor2);
        doctor1.addVaccinationCenter(vc1);
        doctor1.addVaccinationCenter(vc2);

        hs.addVaccinationCenter(vc1);
        hs.addVaccinationCenter(vc2);


        timeslot1.setDoctor(doctor1);
        timeslot1.setPatient(patient1);
        hs.addTimeslot(timeslot1);
        hs.addTimeslot( timeslot2);





    }
}