package com.todolist.domain.service;

import com.todolist.domain.aggregates.task.Priority;
import com.todolist.domain.aggregates.task.TaskStatus;
import org.junit.jupiter.api.Test;
import shared.mocks.CreateTaskDomainServiceMock;

import static org.junit.jupiter.api.Assertions.*;

class CreateTaskDomainServiceTest {

    @Test
    void createTask(){
        var task = CreateTaskDomainServiceMock.create();

        assertNotNull(task);
        assertEquals("Criar uma api rest", task.getTitle());
        assertEquals("Utilizar a linguagem Java", task.getDescription());
        assertEquals(Priority.HIGH, task.getPriority());
        assertEquals(TaskStatus.INITIATED, task.getTaskStatus());
    }
}