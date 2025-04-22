package com.aryanlanhanoja.CourseApplication.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aryanlanhanoja.CourseApplication.beans.Course;

public interface CourseRepository extends JpaRepository<Course,BigInteger>{

    
}