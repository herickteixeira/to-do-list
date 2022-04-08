package com.todolist.application.usecases.task.shared;

import com.todolist.domain.aggregates.task.TaskStatus;

public class TaskStatusRequest {

    private TaskStatus taskStatus;

    public TaskStatusRequest() {
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }
}
