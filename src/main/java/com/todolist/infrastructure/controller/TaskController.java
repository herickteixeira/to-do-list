package com.todolist.infrastructure.controller;

import com.todolist.application.usecases.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CreateTaskUseCase createTaskUseCase;

    @Autowired
    GetAllTasksUserCase getAllTasksUserCase;

    @Autowired
    GetTaskByIdUseCase getTaskByIdUseCase;

    @Autowired
    DeleteTaskById deleteTaskById;

    @Autowired
    UpdateTaskUseCase updateTaskUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<?> createTask(@RequestBody TaskRequest request) {
        var response = createTaskUseCase.execute(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<?> getAllTasks() {
        var response = getAllTasksUserCase.execute();
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<?> getTaskById(@PathVariable Long id) {
        var response = getTaskByIdUseCase.execute(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody TaskRequest request) {
        var response = updateTaskUseCase.execute(id, request);
        return ResponseEntity.ok(response);

    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteTaskById(@PathVariable Long id) {
        deleteTaskById.execute(id);
        return ResponseEntity.ok().build();
    }
}
