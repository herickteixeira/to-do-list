package com.todolist.adapters.persistence.repository;

import com.todolist.domain.entities.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepositoryMongo extends MongoRepository<Task, Long> {
}
