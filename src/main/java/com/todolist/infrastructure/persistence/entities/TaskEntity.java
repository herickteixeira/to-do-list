package com.todolist.infrastructure.persistence.entities;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "tasks")
@Getter
public class TaskEntity {

    @Id
    private String id;

    private String title;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String priority;

    private String taskStatus;

    public TaskEntity(String id, String title, String description, LocalDateTime createdAt, LocalDateTime updatedAt, String priority, String taskStatus) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.priority = priority;
        this.taskStatus = taskStatus;
    }
}
