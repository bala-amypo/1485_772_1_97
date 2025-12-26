package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

import java.util.List;

public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    public Student add(Student student) {
        return studentService.addStudent(student);
    }

    public List<Student> list() {
        return studentService.getAllStudents();
    }
}
