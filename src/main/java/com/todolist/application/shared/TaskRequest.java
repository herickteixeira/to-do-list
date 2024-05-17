package com.todolist.application.shared;

import com.todolist.domain.enums.Priority;
import com.todolist.domain.enums.TaskStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TaskRequest {
    private String title;
    private String description;
    private Priority priority;
    private TaskStatus taskStatus;
}
