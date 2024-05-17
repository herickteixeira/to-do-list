package com.todolist.adapters.persistence.repository;

import com.todolist.adapters.persistence.mappers.TaskEntityMapper;
import com.todolist.domain.entities.Task;
import com.todolist.domain.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    @Autowired
    private TaskRepositoryMongo taskRepositoryMongo;

    @Override
    public Optional<Task> getTaskById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Task> getAllTasks() {
        return List.of();
    }

    @Override
    public void save(Task task) {
        taskRepositoryMongo.save(TaskEntityMapper.map(task));
    }

    @Override
    public void update(Long id, Task task) {

    }

    @Override
    public void delete(Long id) {

    }
}