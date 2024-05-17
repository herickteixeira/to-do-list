package com.todolist.adapters.persistence.mappers;

import com.todolist.adapters.persistence.entities.TaskEntity;
import com.todolist.domain.entities.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskEntityMapper {
    public static TaskEntity map(Task task) {
        return new TaskEntity(task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getCreatedAt(),
                task.getUpdatedAt(),
                task.getPriority().name(),
                task.getTaskStatus().name());
    }

    public static List<TaskEntity> map(List<Task> tasks) {
        var entities = new ArrayList<TaskEntity>();
        for (var task : tasks)
            entities.add(map(task));
        return entities;
    }
}
