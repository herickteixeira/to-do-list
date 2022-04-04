package com.todolist.domain.service;

import com.todolist.domain.aggregates.task.Priority;
import com.todolist.domain.aggregates.task.TaskStatus;
import com.todolist.domain.Task;
import org.springframework.stereotype.Component;

@Component
public class CreateTaskDomainService {
    public static Task execute(String title, String description, Priority priority) {
        var task = new Task(title, description, priority);
        task.setTitle(title);
        task.setDescription(description);
        task.setPriority(priority);
        task.setTaskStatus(TaskStatus.INITIATED);
        return task;
    }
}
