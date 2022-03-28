package com.todolist.application;

import com.todolist.domain.entities.Task;
import com.todolist.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public Task create(Task task) {

        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {

        return taskRepository.findAll();
    }

    public Task getById(Long id) throws Exception {

        Task task = taskRepository.findById(id).get();

        if (task == null) {
            throw new RuntimeException("NOT FOUND");
        }
        return task;
    }

    public Task updateTask(long id, Task newTask) throws Exception {

        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(newTask.getTitle());
                    task.setDescription(newTask.getDescription());
                    task.setPriority(newTask.getPriority());
                    task.setTaskStatus(newTask.getTaskStatus());
                    return taskRepository.save(task);
                })
                .orElseGet(() -> {
                    return taskRepository.save(newTask);
                });
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}
