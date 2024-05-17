package com.todolist.application.shared;

import com.todolist.domain.enums.Priority;
import com.todolist.domain.enums.TaskStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TaskResponse {

    private String id;

    private String title;

    private String description;

    private Priority priority;

    private TaskStatus taskStatus;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
