package com.example.demo.repositories;

import com.example.demo.objectclasses.Doctor;
import com.example.demo.objectclasses.Timeslot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

//Interface for the Timeslot to connect with the JPA Timeslot
public interface TimeslotRepository extends JpaRepository<Timeslot, String> {
    ArrayList<Timeslot> findByDate(String date);
    Timeslot findByTimeslotID(String tid);

    List<Timeslot> findByDateContaining(String month);





}
