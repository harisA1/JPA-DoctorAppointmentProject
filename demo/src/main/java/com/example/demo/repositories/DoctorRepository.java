package com.example.demo.repositories;

import com.example.demo.objectclasses.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, String> {


}
