package com.todolist.domain.service;

import com.todolist.domain.aggregates.task.Priority;
import com.todolist.domain.aggregates.task.TaskStatus;
import com.todolist.domain.entities.Task;
import org.springframework.stereotype.Component;

@Component
public class CreateTaskDomainService {
    public Task execute(String description, Priority priority, String title) {
        var task = new Task(title, description, priority);
        task.setDescription(description);
        task.setPriority(priority);
        task.setTitle(title);
        task.setTaskStatus(TaskStatus.INITIATED);
        return task;
    }
}
