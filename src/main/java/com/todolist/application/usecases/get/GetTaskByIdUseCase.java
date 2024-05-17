package com.todolist.application.usecases.get;

import com.todolist.application.shared.TaskResponse;
import com.todolist.application.shared.TaskResponseMapper;
import com.todolist.domain.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetTaskByIdUseCase {

    @Autowired
    private TaskRepository taskRepository;

    public TaskResponse execute(String id) {
        var optionalTask = taskRepository.getTaskById(id);
        if (optionalTask.isEmpty())
            throw new RuntimeException(String.format("Task of id %s not found", id));

        return TaskResponseMapper.map(optionalTask.get());
    }
}
