package com.todolist.application.usecases.task.delete;

import com.todolist.domain.aggregates.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteTaskById {
    @Autowired
    TaskRepository taskRepository;

    public void execute(Long id) {
        var task = taskRepository.getById(id);
        if (id == null) throw new RuntimeException("NOT FOUND");

        taskRepository.delete(task);
    }
}
