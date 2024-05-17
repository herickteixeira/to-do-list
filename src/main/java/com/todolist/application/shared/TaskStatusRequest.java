package com.todolist.application.shared;

import com.todolist.domain.enums.TaskStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TaskStatusRequest {
    private TaskStatus taskStatus;
}
