package com.todolist.domain.service;

import com.todolist.domain.Task;
import com.todolist.domain.aggregates.task.Priority;
import com.todolist.domain.aggregates.task.TaskStatus;
import org.springframework.stereotype.Component;

@Component
public class CreateTaskDomainService {
    public static Task execute(String title, String description, Priority priority, TaskStatus taskStatus) {
        var task = new Task(title, description, priority, taskStatus);
        task.setTitle(title);
        task.setDescription(description);
        task.setPriority(priority);
        task.setTaskStatus(taskStatus.INITIATED);
        return task;
    }
}
