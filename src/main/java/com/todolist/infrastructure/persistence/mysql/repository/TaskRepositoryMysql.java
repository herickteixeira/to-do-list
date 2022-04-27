package com.todolist.infrastructure.persistence.mysql.repository;

import com.todolist.domain.aggregates.task.Task;
import com.todolist.domain.aggregates.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepositoryMysql implements TaskRepository {

    private final TaskRepositorySpringData springData;

    @Autowired
    public TaskRepositoryMysql(TaskRepositorySpringData springData) {
        this.springData = springData;
    }

    @Override
    public Optional<Task> findById(Long id) {
        var optionalTask = springData.findById(id);
        if (optionalTask.isEmpty()) return Optional.empty();
        return Optional.of(TaskMapper.map(optionalTask.get()));

    }

    @Override
    public List<Task> findAll() {
        var entities = springData.findAll();
        return TaskMapper.map(entities);
    }

    @Override
    public void save(Task task) {
        springData.save(TaskEntityMapper.map(task));
    }

    @Override
    public void delete(Long id) {
        springData.deleteById(id);
    }
}
