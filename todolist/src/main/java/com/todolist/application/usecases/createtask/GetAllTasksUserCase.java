package com.todolist.application.usecases.createtask;

import com.todolist.domain.repository.TaskRepository;
import com.todolist.domain.service.GetAllDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllTasksUserCase {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private GetAllDomainService getAllDomainService;

    public List<TaskResponse> execute() {
        var tasks = taskRepository.findAll();
        return TaskResponseFactory.create(tasks);
    }
}
