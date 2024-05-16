package com.todolist.adapters.persistence.repository;

import com.todolist.domain.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepositoryJpa extends JpaRepository<Task, Long> {
}
