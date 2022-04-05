package com.todolist.application.usecases;

import com.todolist.domain.repository.TaskRepository;
import com.todolist.domain.service.CreateTaskDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateTaskUseCase {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private CreateTaskDomainService createTaskDomainService;

    public TaskResponse execute(TaskRequest request) {

        var task = createTaskDomainService.execute(
                request.getTitle(),
                request.getDescription(),
                request.getPriority(),
                request.getTaskStatus());

        task = taskRepository.save(task);

        return TaskResponseFactory.create(task);
    }
}
