package com.example.dainterntakehome.model;

import jakarta.persistence.*;

@Entity
public class Task {
    public Task() {}
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String title;

    private String description;

    private boolean completed;

    public Task (String title, String description, boolean completed) {
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Task setTitle(String name) {
        this.title = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    public boolean isCompleted() {
        return completed;
    }

    public Task setCompleted(boolean completed) {
        this.completed = completed;
        return this;
    }
}