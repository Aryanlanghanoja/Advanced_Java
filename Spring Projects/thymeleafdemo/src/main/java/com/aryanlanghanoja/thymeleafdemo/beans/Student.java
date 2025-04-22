package com.aryanlanghanoja.thymeleafdemo.beans;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name Is Required")
    @Column(name  = "student_name")
    private String name;

    @NotBlank(message = "Email Is Required")
    @Column(name  = "student_email")
    @NonNull
    private String email;

    @Column(name  = "student_phone")
    private String phone_no;

    public Student() {

    }

    public Student(long id, String name, String email, String phone_no) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone_no = phone_no;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }
}
