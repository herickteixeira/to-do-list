package com.todolist.domain.repositories;

import com.todolist.domain.entities.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    Optional<Task> getTaskById(String id);

    List<Task> getAllTasks();

    void save(Task task);

    void delete(String id);
}
