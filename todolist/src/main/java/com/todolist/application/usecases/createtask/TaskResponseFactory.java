package com.todolist.application.usecases.createtask;

import com.todolist.domain.entities.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskResponseFactory {
    public static TaskResponse create(Task task) {
        var response = new TaskResponse();
        response.setCreatedAt(task.getCreatedAt());
        response.setPriority(task.getPriority());
        response.setTitle(task.getTitle());
        response.setDescription(task.getDescription());
        response.setUpdatedAt(task.getUpdatedAt());
        return response;
    }

    public static List<TaskResponse> create(List<Task> tasks) {
        var responses = new ArrayList<TaskResponse>();
        for (var task : tasks) responses.add(create(task));
        return responses;
    }
}
