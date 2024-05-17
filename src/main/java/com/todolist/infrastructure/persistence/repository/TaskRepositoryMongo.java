package com.todolist.adapters.persistence.repository;

import com.todolist.adapters.persistence.entities.TaskEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepositoryMongo extends MongoRepository<TaskEntity, Long> {
}
