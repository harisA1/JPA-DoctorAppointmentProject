package com.example.demo.hello;

import org.springframework.data.jpa.repository.JpaRepository;

//Interface for the Student to connect with the JPA Student
// Only basic implementations are inherited
public interface StudentRepository extends JpaRepository<Student, String> {
}
