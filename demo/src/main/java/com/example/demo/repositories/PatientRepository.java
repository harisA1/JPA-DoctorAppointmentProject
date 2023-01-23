package com.example.demo.repositories;

import com.example.demo.objectclasses.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, String> {

}

