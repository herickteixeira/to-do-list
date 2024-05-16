package com.todolist.application.usecases.create;

import com.todolist.domain.entities.Task;
import com.todolist.domain.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateTaskUseCase {

    @Autowired
    private TaskRepository taskRepository;

    public void execute(Task task){
        taskRepository.save(task);
    }
}
