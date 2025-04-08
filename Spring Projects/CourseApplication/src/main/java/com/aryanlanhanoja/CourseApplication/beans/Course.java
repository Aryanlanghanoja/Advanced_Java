package com.aryanlanhanoja.CourseApplication.beans;
import java.math.BigInteger;
import jakarta.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "course")
@Entity
@JsonIgnoreProperties({
    "hibernateLazyInitializer", "handler"
})

public class Course {

    @Id
    private BigInteger courseId;
    private String courseName;
    private String courseInstructor ;

    public Course() {
        
    }

    public Course(BigInteger courseId, String courseName, String courseInstructor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseInstructor = courseInstructor;
    }

    public BigInteger getCourseId() {
        return courseId;
    }

    public void setCourseId(BigInteger courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseInstructor() {
        return courseInstructor;
    }

    public void setCourseInstructor(String courseInstructor) {
        this.courseInstructor = courseInstructor;
    }


    
}
