package com.example.demo.controller;

import java.util.List;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentS studentService;

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }
}