package com.todolist.application.usecases;

import com.todolist.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateTaskUseCase {
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    CreateTaskUseCase createTaskUseCase;

    public TaskResponse execute(Long id, TaskRequest request) {
        var task = taskRepository.findById(id);
        if (id == null) throw new RuntimeException("NOT FOUND");
        task.map(response -> {
            response.setTitle(request.getTitle());
            response.setDescription(request.getDescription());
            response.setPriority(request.getPriority());
            return taskRepository.save(response);
        });
        return TaskResponseFactory.create(task);
    }
}
