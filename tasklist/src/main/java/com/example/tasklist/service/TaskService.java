package com.example.tasklist.service;

import com.example.tasklist.model.Task;

import java.util.List;

public interface TaskService {

    public List<Task> findAll();
    public Task save(Task task);
    Task findById(Long id);
}
