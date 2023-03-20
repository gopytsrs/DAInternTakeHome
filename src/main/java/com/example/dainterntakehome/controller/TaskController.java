package com.example.dainterntakehome.controller;

import com.example.dainterntakehome.lib.ResponseHandler;
import com.example.dainterntakehome.model.Task;
import com.example.dainterntakehome.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/tasks")
public class TaskController {
    TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllTasks() {
        try {
            return ResponseHandler
                .responseBuilder(
                        "All tasks retrieved successfully.",
                        HttpStatus.OK,
                        taskService.getAllTasks()
                );
        } catch (Exception e) {
            return ResponseHandler.errorResponse(e.getMessage());

        }
    }

    @PostMapping("/")
    public ResponseEntity<Object> createTask(@RequestBody Task task) {
        try {
            return ResponseHandler
                    .responseBuilder(
                            "Task created successfully.",
                            HttpStatus.CREATED,
                            taskService.createTask(task)
                    );
        } catch (Exception e) {
            return ResponseHandler.errorResponse(e.getMessage());

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTaskById(@PathVariable long id) {
        try {
            return ResponseHandler
                    .responseBuilder(
                            "Task retrieved successfully",
                            HttpStatus.OK,
                            taskService.getTaskById(id)
                    );
        } catch (Exception e) {
            return ResponseHandler.errorResponse(e.getMessage());

        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTask(@PathVariable long id, @RequestBody Task task) {
        try {
            return ResponseHandler
                    .responseBuilder(
                            "Task updated succesfully",
                            HttpStatus.OK,
                            taskService.updateTask(id, task)
                    );
        } catch (Exception e) {
            return ResponseHandler.errorResponse(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTask(@PathVariable long id) {
        try {
            taskService.deleteTask(id);
            return ResponseHandler
                    .responseBuilder(
                            "Task deleted succesfully",
                            HttpStatus.OK,
                            null
                    );
        } catch (Exception e) {
            return ResponseHandler.errorResponse(e.getMessage());

        }
    }

}
