package com.todolist.application.usecases;

import com.todolist.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllTasksUserCase {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskResponse> execute() {
        var tasks = taskRepository.findAll();
        return TaskResponseFactory.create(tasks);
    }
}
