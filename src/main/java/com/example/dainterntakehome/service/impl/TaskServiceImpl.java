package com.example.dainterntakehome.service.impl;

import com.example.dainterntakehome.exception.ResourceNotFoundException;
import com.example.dainterntakehome.model.Task;
import com.example.dainterntakehome.repository.TaskRepository;
import com.example.dainterntakehome.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    private Task checkTaskExists(long id) {
        if (taskRepository.existsById(id)) {
            return taskRepository.findById(id).get();
        }
        throw new ResourceNotFoundException("The task with the specified id does not exist!");
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(long id) {
        Task task = checkTaskExists(id);
        return task;
    }

    @Override
    public Task updateTask(long id, Task task) {
        Task updatedTask = checkTaskExists(id);
        return taskRepository.save(
            updatedTask
                    .setCompleted(task.isCompleted())
                    .setTitle(task.getTitle())
                    .setDescription(task.getDescription())
        );
    }

    @Override
    public void deleteTask(long id) {
        checkTaskExists(id);
        taskRepository.deleteById(id);
    }
}
