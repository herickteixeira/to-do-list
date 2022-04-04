package shared.mocks;

import com.todolist.application.usecases.createtask.TaskRequest;

public class TaskRequestMock {
    public static TaskRequest create() {
        var taskRequest = new TaskRequest();
        taskRequest.setTitle(TaskMock.title);
        taskRequest.setDescription(TaskMock.description);
        taskRequest.setPriority(TaskMock.priority);
        return taskRequest;
    }
}
