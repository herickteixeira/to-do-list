package com.todolist.application.usecases;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import shared.mocks.TaskMock;
import shared.mocks.TaskRequestMock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TaskRequestTest {

    @Test
    @DisplayName("Create task from request")
    void shouldCreateTask() {
        var taskRequest = TaskRequestMock.create();
        assertNotNull(taskRequest);
        assertEquals(TaskMock.title, taskRequest.getTitle());
        assertEquals(TaskMock.description, taskRequest.getDescription());
        assertEquals(TaskMock.priority, taskRequest.getPriority());
    }
}