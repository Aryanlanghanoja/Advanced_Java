package com.aryanlanhanoja.CourseApplication.controller;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.aryanlanhanoja.CourseApplication.beans.Course;
import com.aryanlanhanoja.CourseApplication.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @RequestMapping("/courses")
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }


    @RequestMapping(value = "/addCourse" , method = RequestMethod.POST)
    public void addCourse(@RequestBody Course course) {
         courseRepository.save(course);
    }

    @RequestMapping(value = "/courses/{id}" , method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable BigInteger id) {
        courseRepository.deleteById(id);
    }

    @RequestMapping(value = "/courses/{id}" , method = RequestMethod.GET)
    public Optional<Course> getCourseByID(@PathVariable BigInteger id) {
        return courseRepository.findById(id);
    }    
}
