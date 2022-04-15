package com.todolist.application.usecases.task.delete;

import com.todolist.domain.aggregates.task.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import shared.mocks.TaskMock;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class DeleteTaskByIdUseCaseTest {

    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = Mockito.mock(TaskRepository.class);
    }

    @Test
    @DisplayName("Delete task by id")
    void shouldDeleteById() {
        var useCase = new DeleteTaskByIdUseCase(taskRepository);
        var task = TaskMock.create();
        Mockito.when(taskRepository.findById(anyLong())).thenReturn(Optional.of(task));

        useCase.execute(anyLong());

        verify(taskRepository, times(1)).findById(anyLong());
        verify(taskRepository, times(1)).delete(any());
    }

    @Test
    @DisplayName("Not found id")
    void shouldNotReturnId() {
        var useCase = new DeleteTaskByIdUseCase(taskRepository);
        Mockito.when(taskRepository.findById(any()).isEmpty()).thenThrow(RuntimeException.class);

        assertThrows(RuntimeException.class, () -> useCase.execute(any()));
    }
}