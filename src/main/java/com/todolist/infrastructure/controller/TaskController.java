package com.todolist.infrastructure.controller;

import com.todolist.application.usecases.task.create.CreateTaskUseCase;
import com.todolist.application.usecases.task.delete.DeleteTaskByIdUseCase;
import com.todolist.application.usecases.task.get.GetAllTasksUserCase;
import com.todolist.application.usecases.task.get.GetTaskByIdUseCase;
import com.todolist.application.usecases.task.shared.TaskRequest;
import com.todolist.application.usecases.task.update.UpdateTaskUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final CreateTaskUseCase createTaskUseCase;
    private final GetAllTasksUserCase getAllTasksUserCase;
    private final GetTaskByIdUseCase getTaskByIdUseCase;
    private final DeleteTaskByIdUseCase deleteTaskByIdUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;

    @Autowired
    public TaskController(
            CreateTaskUseCase createTaskUseCase,
            GetAllTasksUserCase getAllTasksUserCase,
            GetTaskByIdUseCase getTaskByIdUseCase,
            DeleteTaskByIdUseCase deleteTaskByIdUseCase,
            UpdateTaskUseCase updateTaskUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.getAllTasksUserCase = getAllTasksUserCase;
        this.getTaskByIdUseCase = getTaskByIdUseCase;
        this.deleteTaskByIdUseCase = deleteTaskByIdUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
    }

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

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<?> getTaskById(@PathVariable Long id) {
        var response = getTaskByIdUseCase.execute(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody TaskRequest request) {
        var response = updateTaskUseCase.execute(id, request);
        return ResponseEntity.ok(response);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteTaskById(@PathVariable Long id) {
        deleteTaskByIdUseCase.execute(id);
        return ResponseEntity.ok().build();
    }
}
