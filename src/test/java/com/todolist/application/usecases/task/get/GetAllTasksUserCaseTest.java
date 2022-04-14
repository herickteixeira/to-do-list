package com.todolist.application.usecases.task.get;

import com.todolist.domain.aggregates.task.Task;
import com.todolist.domain.aggregates.task.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import shared.mocks.TaskMock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GetAllTasksUserCaseTest {

    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = Mockito.mock(TaskRepository.class);
    }

    @Test
    @DisplayName("Return all tasks")
    void findAllTasks() {
        var useCase = new GetAllTasksUserCase(taskRepository);
        List<Task> tasks = new ArrayList<>();
        tasks.add(TaskMock.create());
        Mockito.when(taskRepository.findAll()).thenReturn(tasks);
        var response = useCase.execute();

        assertNotNull(response);
        assertEquals(1, response.size());
    }

    @Test
    @DisplayName(" Return empty List")
    void shouldReturnEmptyList() {
        var useCase = new GetAllTasksUserCase(taskRepository);
        Mockito.when(taskRepository.findAll()).thenReturn(new ArrayList<>());
        var response = useCase.execute();

        assertEquals(0, response.size());
    }
}