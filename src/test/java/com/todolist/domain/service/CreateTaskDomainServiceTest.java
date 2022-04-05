package com.todolist.domain.service;

import com.todolist.domain.aggregates.task.Priority;
import org.junit.jupiter.api.Test;
import shared.mocks.TaskMock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CreateTaskDomainServiceTest {

    @Test
    void shouldCreateDomainService() {
        var task = CreateTaskDomainService.execute(TaskMock.title, TaskMock.description, TaskMock.priority);
        assertNotNull(task);
        assertEquals("Criar uma API rest", task.getTitle());
        assertEquals("Utilizar a linguagem Java", task.getDescription());
        assertEquals(Priority.HIGH, task.getPriority());
    }
}