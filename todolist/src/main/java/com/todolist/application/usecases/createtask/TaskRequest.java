package com.todolist.application.usecases.createtask;

import com.todolist.domain.aggregates.task.Priority;
import com.todolist.domain.aggregates.task.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
public class TaskRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private Priority priority;

    @NotBlank
    private TaskStatus taskStatus;

    @NotBlank
    private Date createdAt;

    @NotBlank
    private Date updatedAt;
}
