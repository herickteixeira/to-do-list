package com.todolist.infrastructure.persistence.mysql.repository;

import com.todolist.domain.aggregates.task.Priority;
import com.todolist.domain.aggregates.task.Task;
import com.todolist.domain.aggregates.task.TaskStatus;

import java.util.ArrayList;
import java.util.List;

public class TaskMapper {
    public static Task map(TaskEntity entity) {
        return Task.materialize(entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                Priority.valueOf(entity.getPriority()),
                TaskStatus.valueOf(entity.getTaskStatus()));
    }

    public static List<Task> map(List<TaskEntity> entities) {
        var tasks = new ArrayList<Task>();
        for (var entity : entities)
            tasks.add(map(entity));
        return tasks;
    }
}
