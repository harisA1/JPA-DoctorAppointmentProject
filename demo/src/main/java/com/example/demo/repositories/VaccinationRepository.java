package com.example.demo.repositories;

import com.example.demo.objectclasses.Patient;
import com.example.demo.objectclasses.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationRepository extends JpaRepository<Vaccination, String> {
    <List>Vaccination findByPatient(Patient patient);
}
