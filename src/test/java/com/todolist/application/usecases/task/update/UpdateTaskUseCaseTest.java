package com.todolist.application.usecases.task.update;

import com.todolist.application.usecases.task.get.GetTaskByIdUseCase;
import com.todolist.domain.aggregates.task.Task;
import com.todolist.domain.aggregates.task.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import shared.mocks.TaskMock;
import shared.mocks.TaskRequestMock;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class UpdateTaskUseCaseTest {

    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = Mockito.mock(TaskRepository.class);
    }

    @Test
    @DisplayName("Update Task")
    void shouldUpdateTask() {
        var useCase = new UpdateTaskUseCase(taskRepository);

        var request = TaskRequestMock.create();
        var task = TaskMock.create();

        Mockito.when(taskRepository.findById(anyLong())).thenReturn(Optional.of(task));
        var response = useCase.execute(anyLong(), request);

        assertNotNull(request);
        assertEquals(response.getDescription(), request.getDescription());
        assertEquals(response.getPriority(), request.getPriority());
        assertEquals(response.getTitle(), request.getTitle());
        verify(taskRepository, times(1)).save(any(Task.class));
    }

    @Test
    @DisplayName("Don't return Id")
    void shouldNotReturnId() {
        var useCase = new GetTaskByIdUseCase(taskRepository);
        Mockito.when(taskRepository.findById(any()).isEmpty()).thenThrow(RuntimeException.class);

        assertThrows(RuntimeException.class, () -> useCase.execute(any()));
    }
}