package com.example.demo.hello;

import com.example.demo.objectclasses.*;
import org.springframework.boot.*;
import org.springframework.context.annotation.*;
import org.springframework.beans.factory.annotation.*;

@Configuration
public class HelloConfiguration implements CommandLineRunner {

    @Autowired
    private HelloService hs;

    @Override
    public void run(String... args) throws Exception {

        Timeslot timeslot1 = new Timeslot("24/04/2023", "10:00");
        Timeslot timeslot2 = new Timeslot("25/04/2023", "11:00");

        Patient patient1 = new Patient("Haris", "Ampas", "23003");
        Patient patient2 = new Patient("Christos", "Ioannou ", "23017");
        Patient patient3 = new Patient("Despoina", "Taskoudi", "23018");

        Doctor doctor1 = new Doctor("123123","Dr. House");
        Doctor doctor2 = new Doctor( "321321","Dr. Who");
        Doctor doctor3 = new Doctor( "312312","Dr. Ampatzoglou");

        VaccinationCenter vc1 = new VaccinationCenter("ΑΧΕΠΑ");
        VaccinationCenter vc2 = new VaccinationCenter("ΓΝΣ ΓΕΝΝΗΜΑΤΑΣ");
        VaccinationCenter vc3 = new VaccinationCenter("ΓΝΣ ΑΓΙΟΣ ΔΗΜΗΤΡΙΟΣ");
        VaccinationCenter vc4 = new VaccinationCenter("ΙΠΠΟΚΡΑΤΕΙΟ");
        VaccinationCenter vc5 = new VaccinationCenter("ΔΕΘ HELEXPO");
        VaccinationCenter vc6 = new VaccinationCenter("ΠΑΜΑΚ");

        hs.addPatient( patient1 );
        hs.addPatient( patient2 );

//        doctor1.addTimeslot(timeslot2);
        hs.addDoctor(doctor1);
        hs.addDoctor(doctor2);

        //hs.addVaccinationCenter(vc1);
        hs.addVaccinationCenter(vc2);
        hs.addVaccinationCenter(vc3);
        hs.addVaccinationCenter(vc4);
        hs.addVaccinationCenter(vc5);
        hs.addVaccinationCenter(vc6);

        //hs.addTimeslot(timeslot1);
        //hs.addTimeslot( timeslot2);

        AvailableTimeslotInVc at1 = new AvailableTimeslotInVc(timeslot1, vc1, doctor1);
        AvailableTimeslotInVc at2 = new AvailableTimeslotInVc(timeslot2, vc1, doctor1);

        hs.addAvailableTimeslot(at1);
        hs.addAvailableTimeslot(at2);
        Appointment appointment1 = new Appointment(timeslot1,patient1);
        hs.addAppointment(appointment1);

//        AvailableTimeslotInVc at2 = new AvailableTimeslotInVc(timeslot2, vc2, doctor1);
//        hs.addAvailableTimeslot(at2);
//        Appointment appointment2 = new Appointment(timeslot2,patient2);
//        hs.addAppointment(appointment2);





    }
}