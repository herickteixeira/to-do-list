package com.todolist.application.shared;

import com.todolist.domain.entities.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskResponseMapper {
    public static TaskResponse map(Task task) {
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

    public static List<TaskResponse> map(List<Task> tasks) {
        var responses = new ArrayList<TaskResponse>();
        for (var task : tasks) responses.add(map(task));
        return responses;
    }
}
