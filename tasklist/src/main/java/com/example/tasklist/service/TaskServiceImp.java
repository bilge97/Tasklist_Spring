package com.example.tasklist.service;

import com.example.tasklist.model.Task;
import com.example.tasklist.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

public class TaskServiceImp implements TaskService {

    private TaskRepository taskRepository;

    public TaskServiceImp(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task findById(Long id) {
        Optional<Task> result = taskRepository.findById(id);

        return result.get();
    }
}
