package com.todolist.domain.service;

import com.todolist.domain.aggregates.task.Priority;
import com.todolist.domain.aggregates.task.TaskStatus;
import org.junit.jupiter.api.Test;
import shared.mocks.TaskMock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CreateTaskDomainServiceTest {

    @Test
    void shouldCreateDomainService() {

        var service = new CreateTaskDomainService();

        var task = service.execute(TaskMock.title, TaskMock.description, TaskMock.priority, TaskStatus.INITIATED);
        assertNotNull(task);
        assertEquals("Criar uma API rest", task.getTitle());
        assertEquals("Utilizar a linguagem Java", task.getDescription());
        assertEquals(Priority.HIGH, task.getPriority());
        assertEquals(TaskStatus.INITIATED, task.getTaskStatus());
    }
}