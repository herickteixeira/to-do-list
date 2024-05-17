package com.todolist.application.usecases.delete;

import com.todolist.domain.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteTaskByIdUseCase {

    @Autowired
    private TaskRepository taskRepository;

    public void execute(String id) {
        var optionalTask = taskRepository.getTaskById(id);

        if (optionalTask.isEmpty())
            throw new RuntimeException("NOT FOUND");

        taskRepository.delete(optionalTask.get().getId());
    }
}
