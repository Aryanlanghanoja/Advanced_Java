package com.aryanlanhanoja.CourseApplication.beans;
import java.math.BigInteger;
import jakarta.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "student")
@Entity
@JsonIgnoreProperties({
    "hibernateLazyInitializer", "handler"
})

public class Student {

    @Id
    private BigInteger studentId;
    private String studentName;
    private String studentEmail ;
    private String studentPhoneNumber;

    public Student() {
        
    }

    public Student(BigInteger studentId, String studentName, String studentEmail, String studentPhoneNumber) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentPhoneNumber = studentPhoneNumber;
    }

    public BigInteger getStudentId() {
        return studentId;
    }

    public void setStudentId(BigInteger studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentPhoneNumber() {
        return studentPhoneNumber;
    }

    public void setStudentPhoneNumber(String studentPhoneNumber) {
        this.studentPhoneNumber = studentPhoneNumber;
    }
}
