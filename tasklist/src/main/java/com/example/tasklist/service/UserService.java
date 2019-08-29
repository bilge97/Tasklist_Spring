package com.example.tasklist.service;


import com.example.tasklist.model.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();
    public User save(User user);
    User findByUsername(String username);
}
