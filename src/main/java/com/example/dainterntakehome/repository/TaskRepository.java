package com.example.dainterntakehome.repository;

import com.example.dainterntakehome.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository  extends JpaRepository<Task, Long> {
    Optional<Task> findById(long id);
    void deleteById(long id);
}
