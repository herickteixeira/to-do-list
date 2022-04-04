package shared.mocks;

import com.todolist.application.usecases.createtask.TaskResponse;

public class TaskResponseMock {

    public static TaskResponse create() {
        var taskResponse = new TaskResponse();
        taskResponse.setTitle(TaskMock.title);
        taskResponse.setDescription(TaskMock.description);
        taskResponse.setPriority(TaskMock.priority);
        return taskResponse;
    }
}
