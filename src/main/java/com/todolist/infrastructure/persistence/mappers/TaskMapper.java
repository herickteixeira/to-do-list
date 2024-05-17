package com.todolist.infrastructure.persistence.mappers;

import com.todolist.domain.entities.Task;
import com.todolist.domain.enums.Priority;
import com.todolist.domain.enums.TaskStatus;
import com.todolist.infrastructure.persistence.entities.TaskEntity;

import java.util.ArrayList;
import java.util.List;

public class TaskMapper {
    public static Task map(TaskEntity entity) {
        return new Task(entity.getId(),
                entity.getCreatedAt(),
                entity.getTitle(),
                entity.getDescription(),
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
