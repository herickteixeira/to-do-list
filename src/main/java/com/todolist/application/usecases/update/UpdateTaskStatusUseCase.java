package com.todolist.application.usecases.update;

import com.todolist.application.shared.TaskResponse;
import com.todolist.application.shared.TaskResponseMapper;
import com.todolist.application.shared.TaskStatusRequest;
import com.todolist.domain.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateTaskStatusUseCase {

    @Autowired
    private TaskRepository taskRepository;

    public TaskResponse execute(String id, TaskStatusRequest status) {
        var optionalTask = taskRepository.getTaskById(id);

        if (optionalTask.isEmpty())
            throw new IllegalArgumentException("NOT FOUND");

        var task = optionalTask.get();

        task.updateStatus(status.getTaskStatus());

        taskRepository.save(task);

        return TaskResponseMapper.map(task);
    }
}
