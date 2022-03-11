package com.todolist.infrastructure.controller;

import com.todolist.application.TaskService;
import com.todolist.application.usecases.createtask.CreateTaskUseCase;
import com.todolist.application.usecases.createtask.TaskRequest;
import com.todolist.application.usecases.createtask.TaskResponse;
import com.todolist.domain.aggregates.task.Task;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CreateTaskUseCase createTaskUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<?> createTask(@RequestBody TaskRequest request) {
        var response = createTaskUseCase.execute(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @ResponseBody
    public List<TaskResponse> getAllTasks() {
        return taskService.getAllTasks().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> getTaskById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(convertToDto(taskService.getById(id)));
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
