package shared.mocks;

import com.todolist.application.usecases.task.shared.TaskRequest;
import com.todolist.domain.aggregates.task.Priority;

public class TaskRequestMock {

    public static final String title = "Criar uma API rest";
    public static final String description = "Utilizar a linguagem Java";
    public static final Priority priority = Priority.HIGH;

    public static TaskRequest create() {
        var taskRequest = new TaskRequest();
        taskRequest.setTitle(TaskRequestMock.title);
        taskRequest.setDescription(TaskRequestMock.description);
        taskRequest.setPriority(TaskRequestMock.priority);
        return taskRequest;
    }
}
