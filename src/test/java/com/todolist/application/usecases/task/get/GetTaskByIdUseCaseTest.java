package com.todolist.application.usecases.task.get;

import com.todolist.domain.aggregates.task.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import shared.mocks.TaskMock;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class GetTaskByIdUseCaseTest {

    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = Mockito.mock(TaskRepository.class);
    }

    @Test
    @DisplayName("Get by Id")
    void getTaskById() {
        var useCase = new GetTaskByIdUseCase(taskRepository);
        var task = TaskMock.create();
        Mockito.when(taskRepository.findById(anyLong())).thenReturn(Optional.of(task));

        var response = useCase.execute(anyLong());

        assertNotNull(response);
        verify(taskRepository, times(1)).findById(anyLong());
    }

    @Test
    @DisplayName("Don't return Id")
    void shouldNotReturnId() {
        var useCase = new GetTaskByIdUseCase(taskRepository);
        Mockito.when(taskRepository.findById(any()).isEmpty()).thenThrow(RuntimeException.class);

        assertThrows(RuntimeException.class, () -> useCase.execute(any()));
    }
}