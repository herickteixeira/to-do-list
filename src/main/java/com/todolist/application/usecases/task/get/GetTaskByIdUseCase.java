package com.todolist.application.usecases.task.get;

import com.todolist.application.usecases.task.shared.TaskResponse;
import com.todolist.application.usecases.task.shared.TaskResponseMapper;
import com.todolist.domain.aggregates.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetTaskByIdUseCase {

    private final TaskRepository taskRepository;

    @Autowired
    public GetTaskByIdUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskResponse execute(Long id) {
        var optionalTask = taskRepository.findById(id);

        if (optionalTask.isEmpty())
            throw new RuntimeException(String.format("Task of id %s no found", id));

        var task = optionalTask.get();

        return TaskResponseMapper.map(task);
    }
}
