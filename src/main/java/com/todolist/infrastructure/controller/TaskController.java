package com.todolist.infrastructure.controller;

import com.todolist.application.TaskService;
import com.todolist.application.usecases.createtask.*;
import com.todolist.domain.Task;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CreateTaskUseCase createTaskUseCase;

    @Autowired
    GetAllTasksUserCase getAllTasksUserCase;

    @Autowired
    GetTaskByIdUseCase getTaskByIdUseCase;

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
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody TaskRequest request) throws Exception {
        Task task = convertToEntity(request);
        return ResponseEntity.ok(convertToDto(taskService.updateTask(id, task)));

    }

    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }


    private TaskResponse convertToDto(Task task) {
        return modelMapper.map(task, TaskResponse.class);
    }

    private Task convertToEntity(TaskRequest request) {
        return modelMapper.map(request, Task.class);
    }
}
