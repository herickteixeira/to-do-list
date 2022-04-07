package com.todolist.application.usecases;

import com.todolist.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetTaskByIdUseCase {

    @Autowired
    TaskRepository taskRepository;

    public TaskResponse execute(Long id) {
        var optionalTask = taskRepository.findById(id);

        if (optionalTask.isEmpty())
            throw new RuntimeException(String.format("Task of id %s no found", id));

        var task = optionalTask.get();

        return TaskResponseFactory.create(task);
    }
}
