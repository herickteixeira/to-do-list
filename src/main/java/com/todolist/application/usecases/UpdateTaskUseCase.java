package com.todolist.application.usecases;

import com.todolist.application.shared.TaskRequest;
import com.todolist.application.shared.TaskResponse;
import com.todolist.application.shared.TaskResponseMapper;
import com.todolist.domain.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateTaskUseCase {

    private final TaskRepository taskRepository;

    @Autowired
    public UpdateTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskResponse execute(String id, TaskRequest request) {
        var optionalTask = taskRepository.getTaskById(id);

        if (optionalTask.isEmpty())
            throw new IllegalArgumentException("NOT FOUND");

        var task = optionalTask.get();

        task.update(request.getTitle(), request.getDescription(), request.getPriority());

        taskRepository.save(task);

        return TaskResponseMapper.map(task);
    }
}
