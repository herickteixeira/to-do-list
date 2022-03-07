package com.todolist.controller;

import com.todolist.dto.TaskDto;
import com.todolist.model.Task;
import com.todolist.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public TaskDto createTask(@RequestBody TaskDto taskDto){

        Task task = convertToEntity(taskDto);
        Task taskCreated = taskService.create(task);
        return convertToDto(taskCreated);
    }

    @GetMapping
    @ResponseBody
    public List<TaskDto> getAllTasks(){

        return taskService.getAllTasks().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    @ResponseBody
    public TaskDto getTaskById(@PathVariable Long id) throws Exception {

        return convertToDto(taskService.getById(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskDto updateTask(@PathVariable Long id, @RequestBody TaskDto taskDto) throws Exception {

        Task task = convertToEntity(taskDto);
        return convertToDto(taskService.updateTask(id, task));

    }

    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }


    private TaskDto convertToDto(Task task) {
        TaskDto taskDto = modelMapper.map(task, TaskDto.class);
        return taskDto;
    }

    private Task convertToEntity(TaskDto taskDto) {
        Task task = modelMapper.map(taskDto, Task.class);
        return task;
    }
}
