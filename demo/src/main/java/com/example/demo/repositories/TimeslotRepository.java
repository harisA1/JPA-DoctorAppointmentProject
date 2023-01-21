package com.example.demo.repositories;

import com.example.demo.objectclasses.Timeslot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

//Interface for the Timeslot to connect with the JPA Timeslot
public interface TimeslotRepository extends JpaRepository<Timeslot, String> {
    ArrayList<Timeslot> findByDate(String date);

}
