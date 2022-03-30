package com.todolist.domain.entities;

import com.todolist.domain.aggregates.task.Priority;
import com.todolist.domain.aggregates.task.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @CreationTimestamp
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    @Column(nullable = false)
    private Priority priority;

    private TaskStatus taskStatus;

    public Task(Long id, String title, String description, Date createdAt, Date updatedAt, Priority priority, TaskStatus taskStatus) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.priority = priority;
        this.taskStatus = taskStatus;
    }

    public Task(String title, String description, Priority priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public static Task create(String title, String description, Priority priority) {
        var task = new Task(title, description, priority);
        if(task == null) new IllegalArgumentException("Object invalid");

        return task;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }
}
