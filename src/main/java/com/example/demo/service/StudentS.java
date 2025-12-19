package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Student;

public interface StudentS {
    Student addStudent(Student student);
    List<Student> getAllStudents();
}