package shared.mocks;

import com.todolist.domain.aggregates.task.Priority;
import com.todolist.domain.entities.Task;

public class TaskMock {

    public static final String title = "Criar uma API rest";
    public static final String description = "Criar uma API rest";
    public static final Priority priority = Priority.HIGH;

    public static Task create(){
        return Task.create(TaskMock.title, TaskMock.description, TaskMock.priority);
    }
}
