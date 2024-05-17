package com.todolist.infrastructure.persistence.repository;

import com.todolist.infrastructure.persistence.entities.TaskEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepositoryMongo extends MongoRepository<TaskEntity, String> {
}
