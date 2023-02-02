package com.example.demo.vac;

import com.example.demo.objectclasses.*;
import org.springframework.boot.*;
import org.springframework.context.annotation.*;
import org.springframework.beans.factory.annotation.*;

@Configuration
public class VacConfiguration implements CommandLineRunner {

    @Autowired
    private VacService vs;

    @Override
    public void run(String... args) throws Exception {

        Timeslot timeslot1 = new Timeslot("24/04/2023", "10:00");
        Timeslot timeslot2 = new Timeslot("25/04/2023", "11:00");

        Patient patient1 = new Patient("Haris", "Ampas", "23003");
        Patient patient2 = new Patient("Christos", "Ioannou", "23017");
        Patient patient3 = new Patient("Despoina", "Taskoudi", "23041");

        Doctor doctor1 = new Doctor( "312312","Dr.Ampatzoglou");
        Doctor doctor3 = new Doctor("123123","Dr.House");
        Doctor doctor2 = new Doctor( "321321","Dr.Who");

        VaccinationCenter vc1 = new VaccinationCenter("ΑΧΕΠΑ");
        VaccinationCenter vc2 = new VaccinationCenter("ΓΝΣ ΓΕΝΝΗΜΑΤΑΣ");
        VaccinationCenter vc3 = new VaccinationCenter("ΓΝΣ ΑΓΙΟΣ ΔΗΜΗΤΡΙΟΣ");
        VaccinationCenter vc4 = new VaccinationCenter("ΙΠΠΟΚΡΑΤΕΙΟ");
        VaccinationCenter vc5 = new VaccinationCenter("ΔΕΘ HELEXPO");
        VaccinationCenter vc6 = new VaccinationCenter("ΠΑΜΑΚ");

        vs.addPatient(patient1);
        vs.addPatient(patient2);
        vs.addPatient(patient3);

        vs.addDoctor(doctor1);
        vs.addDoctor(doctor2);

        vs.addVaccinationCenter(vc1);
        vs.addVaccinationCenter(vc2);
        vs.addVaccinationCenter(vc3);
        vs.addVaccinationCenter(vc4);
        vs.addVaccinationCenter(vc5);
        vs.addVaccinationCenter(vc6);

        AvailableTimeslotInVc at1 = new AvailableTimeslotInVc(timeslot1, vc1, doctor1);
        AvailableTimeslotInVc at2 = new AvailableTimeslotInVc(timeslot2, vc1, doctor1);

        vs.addAvailableTimeslot(at1);
        vs.addAvailableTimeslot(at2);

        Appointment appointment1 = new Appointment();
        Appointment appointment2 = new Appointment();

        //setting patient and timeslot before adding
        //(only performed in configuration - @ResponseBody in POST requests sets the entity properly)
        appointment1.setPatient(patient1);
        appointment1.setTimeslot(timeslot1);
        appointment2.setPatient(patient2);
        appointment2.setTimeslot(timeslot2);

        vs.addAppointment(appointment1);
        vs.addAppointment(appointment2);

        Vaccination vaccination1 = new Vaccination(timeslot1.getDate());
        Vaccination vaccination2 = new Vaccination(timeslot2.getDate());
        Vaccination vaccination3 = new Vaccination(timeslot2.getDate());
        //setting patient and doctor before adding
        //(only in configuration - same as appointment)
        vaccination1.setPatient(patient1);
        vaccination1.setDoctor(doctor1);
        vaccination2.setPatient(patient2);
        vaccination2.setDoctor(doctor2);
        vaccination3.setPatient(patient3);
        vaccination3.setDoctor(doctor3);

        vs.addVaccination(vaccination1);
        vs.addVaccination(vaccination2);
        vs.addVaccination(vaccination3);







    }
}