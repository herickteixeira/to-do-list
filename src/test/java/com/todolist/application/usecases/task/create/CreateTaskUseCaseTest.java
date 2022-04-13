package com.todolist.application.usecases.task.create;

import com.todolist.domain.aggregates.task.Task;
import com.todolist.domain.aggregates.task.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import shared.mocks.TaskRequestMock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class CreateTaskUseCaseTest {

    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = Mockito.mock(TaskRepository.class);
    }

    @Test
    @DisplayName("Create Task")
    void createTask() {
        var useCase = new CreateTaskUseCase(taskRepository);
        var request = TaskRequestMock.create();

        var response = useCase.execute(request);

        assertNotNull(request);
        assertEquals(response.getDescription(), request.getDescription());
        assertEquals(response.getPriority(), request.getPriority());
        assertEquals(response.getTitle(), request.getTitle());
        verify(taskRepository, times(1)).save(any(Task.class));
    }
}