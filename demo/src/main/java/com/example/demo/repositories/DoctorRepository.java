package com.example.demo.repositories;

import com.example.demo.objectclasses.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, String> {

    Optional<Doctor> findByDamka(String damka);
}
