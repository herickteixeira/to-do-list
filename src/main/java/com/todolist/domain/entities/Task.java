package com.todolist.domain.entities;

import com.todolist.domain.enums.Priority;
import com.todolist.domain.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Task {
    private Long id;
    private final LocalDateTime createdAt;
    private String title;
    private String description;
    private LocalDateTime updatedAt;
    private Priority priority;
    private TaskStatus taskStatus;

    private Task(String title, String description, Priority priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.createdAt = LocalDateTime.now();
        this.taskStatus = TaskStatus.INITIATED;
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

    public void updateStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
        this.updatedAt = LocalDateTime.now();
    }
}
