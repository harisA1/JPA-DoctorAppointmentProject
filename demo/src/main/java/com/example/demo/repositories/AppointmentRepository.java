package com.example.demo.repositories;

import com.example.demo.objectclasses.Appointment;
import com.example.demo.objectclasses.Doctor;
import com.example.demo.objectclasses.Patient;
import com.example.demo.objectclasses.Timeslot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, String> {

    //findBy methods for specific requests

    <List>Appointment findByPatient(Patient patient);

    List <Appointment> findByTimeslot(Timeslot timeslot);

    List<Appointment> findByTimeslotDoctor(Doctor doctor);



}