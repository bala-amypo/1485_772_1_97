package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;

public interface StudentService {

    User createUser(User user);

    List<User> getAllUsers();
}
