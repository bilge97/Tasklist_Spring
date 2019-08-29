package com.example.tasklist.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "task")
    private String task;

    @ManyToMany(mappedBy = "tasks")
    private Set<User> users;

    public Task() {
    }

    public Task(String task, Set<User> users) {
        this.task = task;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
