package com.todolist.application.usecases.createtask;

import com.todolist.domain.entities.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskResponseFactory {
    public static TaskResponse create(Task task) {
        var response = new TaskResponse();
        response.setId(task.getId());
        response.setCreatedAt(task.getCreatedAt());
        response.setPriority(task.getPriority());
        response.setTitle(task.getTitle());
        response.setDescription(task.getDescription());
        response.setUpdatedAt(task.getUpdatedAt());
        return response;
    }

    public static List<TaskResponse> getAllTasks(){
        var response = new ArrayList<TaskResponse>();

        return response;
    }
}
