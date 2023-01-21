package com.example.demo.repositories;

import com.example.demo.objectclasses.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter, String> {
}