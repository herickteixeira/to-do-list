package com.todolist.application.usecases.task.get;

import com.todolist.application.usecases.task.shared.TaskResponse;
import com.todolist.application.usecases.task.shared.TaskResponseMapper;
import com.todolist.domain.aggregates.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllTasksUserCase {

    private final TaskRepository taskRepository;

    @Autowired
    public GetAllTasksUserCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskResponse> execute() {
        var tasks = taskRepository.findAll();
        return TaskResponseMapper.map(tasks);
    }
}
