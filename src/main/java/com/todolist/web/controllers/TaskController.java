package com.todolist.web.controllers;

import com.todolist.application.shared.TaskRequest;
import com.todolist.application.shared.TaskResponse;
import com.todolist.application.usecases.create.CreateTaskUseCase;
import com.todolist.application.usecases.get.GetAllTasksUseCase;
import com.todolist.domain.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private CreateTaskUseCase createTaskUseCase;

    @Autowired
    private GetAllTasksUseCase getAllTasksUseCase;

    @PostMapping
    public ResponseEntity<Task> save(@RequestBody TaskRequest taskRequest) {
        createTaskUseCase.execute(taskRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAllItems() {
        var taskResponse = getAllTasksUseCase.execute();
        return ResponseEntity.ok(taskResponse);
    }
}
