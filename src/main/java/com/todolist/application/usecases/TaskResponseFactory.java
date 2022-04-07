package com.todolist.application.usecases;

import com.todolist.domain.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskResponseFactory {
    public static TaskResponse create(Task task) {
        var response = new TaskResponse();
        response.setId(task.getId());
        response.setTitle(task.getTitle());
        response.setDescription(task.getDescription());
        response.setPriority(task.getPriority());
        response.setTaskStatus(task.getTaskStatus());
        response.setCreatedAt(task.getCreatedAt());
        response.setUpdatedAt(task.getUpdatedAt());
        return response;
    }

    public static List<TaskResponse> create(List<Task> tasks) {
        var responses = new ArrayList<TaskResponse>();
        for (var task : tasks) responses.add(create(task));
        return responses;
    }
}
