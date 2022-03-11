package com.todolist.application.usecases.createtask;

import com.todolist.domain.aggregates.task.Priority;
import com.todolist.domain.aggregates.task.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TaskResponse {

    private Long id;

    private String title;

    private String description;

    private Priority priority;

    private TaskStatus taskStatus;

    private Date createdAt;

    private Date updatedAt;
}
