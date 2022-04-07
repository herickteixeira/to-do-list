package com.todolist.application.usecases.task.delete;

import com.todolist.domain.aggregates.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteTaskByIdUseCase {

    private final TaskRepository taskRepository;

    @Autowired
    public DeleteTaskByIdUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void execute(Long id) {
        var optionalTask = taskRepository.findById(id);

        if (optionalTask.isEmpty())
            throw new RuntimeException("NOT FOUND");

        taskRepository.delete(optionalTask.get());
    }
}
