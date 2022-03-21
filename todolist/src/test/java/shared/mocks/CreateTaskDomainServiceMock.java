package shared.mocks;

import com.todolist.application.usecases.createtask.TaskRequest;
import com.todolist.domain.aggregates.task.Priority;
import com.todolist.domain.aggregates.task.TaskStatus;

public class CreateTaskDomainServiceMock {

    public static TaskRequest create() {
        var taskRequest = new TaskRequest();
        taskRequest.setTitle("Criar uma api rest");
        taskRequest.setDescription("Utilizar a linguagem Java");
        taskRequest.setPriority(Priority.HIGH);
        taskRequest.setTaskStatus(TaskStatus.INITIATED);

        return taskRequest;
    }
}
