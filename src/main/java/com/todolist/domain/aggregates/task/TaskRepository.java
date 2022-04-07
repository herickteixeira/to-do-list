package com.todolist.domain.aggregates.task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    Optional<Task> findById(Long id);

    List<Task> findAll();

    void save(Task task);

    void delete(Long id);
}
