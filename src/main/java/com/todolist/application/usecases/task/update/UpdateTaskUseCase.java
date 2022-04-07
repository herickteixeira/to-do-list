package com.todolist.application.usecases.task.update;

import com.todolist.application.usecases.task.shared.TaskRequest;
import com.todolist.application.usecases.task.shared.TaskResponse;
import com.todolist.application.usecases.task.shared.TaskResponseMapper;
import com.todolist.domain.aggregates.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateTaskUseCase {

    private final TaskRepository taskRepository;

    @Autowired
    public UpdateTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskResponse execute(Long id, TaskRequest request) {
        var optionalTask = taskRepository.findById(id);

        if (optionalTask.isEmpty())
            throw new IllegalArgumentException("NOT FOUND");

        var task = optionalTask.get();

        task.update(request.getTitle(), request.getDescription(), request.getPriority());

        taskRepository.save(task);

        return TaskResponseMapper.map(task);
    }
}
