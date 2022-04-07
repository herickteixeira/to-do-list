package com.todolist.application.usecases.task.create;

import com.todolist.application.usecases.task.shared.TaskRequest;
import com.todolist.application.usecases.task.shared.TaskResponse;
import com.todolist.application.usecases.task.shared.TaskResponseMapper;
import com.todolist.domain.aggregates.task.TaskRepository;
import com.todolist.domain.service.task.CreateTaskDomainService;
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

        return TaskResponseMapper.map(task);
    }
}
