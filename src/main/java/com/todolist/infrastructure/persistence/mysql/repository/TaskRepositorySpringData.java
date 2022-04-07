package com.todolist.infrastructure.persistence.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepositorySpringData extends JpaRepository<TaskEntity, Long> {
}
