package com.aryanlanhanoja.CourseApplication.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aryanlanhanoja.CourseApplication.beans.Student;

public interface StudentRepository extends JpaRepository<Student, BigInteger> {
    // Custom query methods can be defined here if needed

    
}
