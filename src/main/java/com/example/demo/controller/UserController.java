package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final StudentService studentService;

    public UserController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping("/add")
    public User createUser(@RequestBody User user) {
        return studentService.createUser(user);
    }

    @GetMapping("/all")
    public List<User> showUsers() {
        return studentService.getAllUsers();
    }
}
