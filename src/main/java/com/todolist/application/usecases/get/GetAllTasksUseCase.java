package com.todolist.application.usecases.get;

import com.todolist.application.shared.TaskResponse;
import com.todolist.application.shared.TaskResponseMapper;
import com.todolist.domain.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllTasksUseCase {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskResponse> execute() {
        var tasks = taskRepository.getAllTasks();
        return TaskResponseMapper.map(tasks);
    }
}
