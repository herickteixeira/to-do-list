package com.todolist.dto;

import com.todolist.enums.Priority;
import com.todolist.enums.TaskStatus;
import com.todolist.model.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {


    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private Priority priority;

    @NotBlank
    private TaskStatus taskStatus;

    public TaskDto(Task task) {
    }


}
