package com.todolist.domain.service;

import com.todolist.domain.entities.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetAllDomainService {
    public List<Task> execute() {
        var tasks = new ArrayList<Task>();
        return tasks;
    }
}
