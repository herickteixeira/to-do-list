package com.todolist.application.usecases;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import shared.mocks.TaskMock;
import shared.mocks.TaskResponseMock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TaskResponseTest {

    @Test
    @DisplayName("Create task from response")
    void shouldTaskResponse() {
        var taskResponse = TaskResponseMock.create();
        assertNotNull(taskResponse);
        assertEquals(TaskMock.title, taskResponse.getTitle());
        assertEquals(TaskMock.description, taskResponse.getDescription());
        assertEquals(TaskMock.priority, taskResponse.getPriority());
    }
}