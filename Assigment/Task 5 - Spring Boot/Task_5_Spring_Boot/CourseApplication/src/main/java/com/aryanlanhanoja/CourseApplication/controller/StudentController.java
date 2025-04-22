package com.aryanlanhanoja.CourseApplication.controller;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.aryanlanhanoja.CourseApplication.beans.Student;

import com.aryanlanhanoja.CourseApplication.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping("/students")
    public List<Student> getAllstudent() {
        return studentRepository.findAll();
    }


    @RequestMapping(value = "/addStudent" , method = RequestMethod.POST)
    public void addCourse(@RequestBody Student student) {
         studentRepository.save(student);
    }

    @RequestMapping(value = "/students/{id}" , method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable BigInteger id) {
        studentRepository.deleteById(id);
    }

    @RequestMapping(value = "/students/{id}" , method = RequestMethod.GET)
    public Optional<Student> getCourseByID(@PathVariable BigInteger id) {
        return studentRepository.findById(id);
    }
    
    @RequestMapping(value = "/updateStudent" , method = RequestMethod.PUT)
    public void updateCourse(@RequestBody Student student) {
         studentRepository.save(student);
    }
}
