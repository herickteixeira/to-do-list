package com.todolist.domain.aggregates.task;

import java.time.LocalDateTime;

public class Task {
    private Long id;
    private String title;
    private String description;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Priority priority;
    private final TaskStatus taskStatus;

    private Task(
            String title,
            String description,
            Priority priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.createdAt = LocalDateTime.now();
        this.taskStatus = TaskStatus.INITIATED;
    }

    private Task(
            Long id,
            String title,
            String description,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            Priority priority,
            TaskStatus taskStatus) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.priority = priority;
        this.taskStatus = taskStatus;
    }

    public static Task materialize(
            Long id,
            String title,
            String description,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            Priority priority,
            TaskStatus taskStatus) {
        return new Task(id, title, description, createdAt, updatedAt, priority, taskStatus);
    }

    public static Task create(String title, String description, Priority priority) {
        return new Task(title, description, priority);
    }

    public void update(String title, String description, Priority priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Priority getPriority() {
        return priority;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }
}
