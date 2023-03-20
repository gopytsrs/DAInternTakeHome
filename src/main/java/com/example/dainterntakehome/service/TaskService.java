package com.example.dainterntakehome.service;

import com.example.dainterntakehome.model.Task;

import java.util.List;

public interface TaskService {
    public List<Task> getAllTasks();
    public Task createTask(Task task);
    public Task updateTask(long id, Task task);
    public void deleteTask(long id);
    public Task getTaskById(long id);
}
