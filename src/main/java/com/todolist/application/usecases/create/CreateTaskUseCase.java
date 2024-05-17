package com.todolist.application.usecases.create;

import com.todolist.application.shared.TaskRequest;
import com.todolist.domain.entities.Task;
import com.todolist.domain.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateTaskUseCase {

    @Autowired
    private TaskRepository taskRepository;

    public void execute(TaskRequest taskRequest) {
        var task = Task.create(taskRequest.getTitle(), taskRequest.getDescription(), taskRequest.getPriority());
        taskRepository.save(task);
    }
}
