package com.todolist.adapters.persistence.mappers;

import com.todolist.adapters.persistence.entities.TaskEntity;
import com.todolist.domain.entities.Task;
import com.todolist.domain.enums.Priority;
import com.todolist.domain.enums.TaskStatus;

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
