package com.todolist.application.usecases;

import com.todolist.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetTaskByIdUseCase {
    @Autowired
    TaskRepository taskRepository;

    public TaskResponse execute(Long id) {
        var task = taskRepository.findById(id);
        return TaskResponseFactory.create(task);
    }
}
