package com.todolist.application.usecases;

import com.todolist.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateTaskUseCase {

    @Autowired
    TaskRepository taskRepository;

    public TaskResponse execute(Long id, TaskRequest request) {
        var optionalTask = taskRepository.findById(id);

        if (optionalTask.isEmpty())
            throw new IllegalArgumentException("NOT FOUND");

        var task = optionalTask.get();

        task.update(request.getTitle(), request.getDescription(), request.getPriority());

        taskRepository.save(task);

        return TaskResponseFactory.create(task);
    }
}
