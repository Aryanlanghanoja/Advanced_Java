package com.aryanlanghanoja.thymeleafdemo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aryanlanghanoja.thymeleafdemo.beans.Student;
import com.aryanlanghanoja.thymeleafdemo.repository.StudentRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;





@Controller
@RequestMapping("/students/")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("list")
    public String index(Model model) {
        model.addAttribute("students" , studentRepository.findAll());
        return "index";
    }

    @GetMapping("signup")
    public String showSignUpForm(Student student) {
        return "add_student";
    }

    @PostMapping("add")
    public String addStudent(@Validated Student student , BindingResult result , Model model) {

        if(result.hasErrors()) {
            return "add_student";
        }

        studentRepository.save(student);
        return "redirect:list";
    }

    @GetMapping("delete/{id}")
    public String getMethodName(@PathVariable("id") long id  ,Model model) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Student ID " + id));
        studentRepository.delete(student);
        model.addAttribute("students" , studentRepository.findAll());

        return "index";
    }
    
}
