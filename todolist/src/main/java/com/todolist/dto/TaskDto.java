package com.todolist.dto;

import com.todolist.enums.Priority;
import com.todolist.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {


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
