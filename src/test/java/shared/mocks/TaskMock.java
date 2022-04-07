package shared.mocks;

import com.todolist.domain.aggregates.task.Task;
import com.todolist.domain.aggregates.task.Priority;
import com.todolist.domain.aggregates.task.TaskStatus;

public class TaskMock {

    public static final String title = "Criar uma API rest";
    public static final String description = "Utilizar a linguagem Java";
    public static final Priority priority = Priority.HIGH;
    public static final TaskStatus taskStatus = TaskStatus.INITIATED;

    public static Task create() {
        return Task.create(TaskMock.title, TaskMock.description, TaskMock.priority, TaskStatus.INITIATED);
    }
}
