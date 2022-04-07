package com.todolist.application.usecases.task.create;

import com.todolist.application.usecases.task.shared.TaskRequest;
import com.todolist.application.usecases.task.shared.TaskResponse;
import com.todolist.application.usecases.task.shared.TaskResponseMapper;
import com.todolist.domain.aggregates.task.Task;
import com.todolist.domain.aggregates.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateTaskUseCase {

    private final TaskRepository taskRepository;

    @Autowired
    public CreateTaskUseCase(
            TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskResponse execute(TaskRequest request) {

        var task = Task.create(request.getTitle(),
                request.getDescription(),
                request.getPriority());

        taskRepository.save(task);

        return TaskResponseMapper.map(task);
    }
}
