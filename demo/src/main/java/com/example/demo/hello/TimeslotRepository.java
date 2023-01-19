package com.example.demo.hello;

import org.springframework.data.jpa.repository.JpaRepository;

//Interface for the Timeslot to connect with the JPA Timeslot
public interface TimeslotRepository extends JpaRepository<Timeslot, String> {
}
