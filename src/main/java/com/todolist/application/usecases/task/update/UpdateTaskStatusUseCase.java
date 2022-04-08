package com.todolist.application.usecases.task.update;

import com.todolist.application.usecases.task.shared.TaskResponse;
import com.todolist.application.usecases.task.shared.TaskResponseMapper;
import com.todolist.application.usecases.task.shared.TaskStatusRequest;
import com.todolist.domain.aggregates.task.TaskRepository;
import com.todolist.domain.aggregates.task.TaskStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateTaskStatusUseCase {

    private TaskRepository taskRepository;

    @Autowired
    public UpdateTaskStatusUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskResponse execute(Long id, TaskStatusRequest status) {
        var optionalTask = taskRepository.findById(id);

        if (optionalTask.isEmpty())
            throw new IllegalArgumentException("NOT FOUND");

        var task = optionalTask.get();

        task.updateStatus(task.getTitle(), task.getDescription(), task.getPriority(), status.getTaskStatus());

        taskRepository.save(task);

        return TaskResponseMapper.map(task);
    }
}
