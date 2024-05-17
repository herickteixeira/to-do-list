package com.todolist.infrastructure.persistence.mappers;

import com.todolist.domain.entities.Task;
import com.todolist.infrastructure.persistence.entities.TaskEntity;

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
