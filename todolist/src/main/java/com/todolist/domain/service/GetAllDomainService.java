package com.todolist.domain.service;

import com.todolist.domain.entities.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class GetAllDomainService{
    public  ArrayList<Task> execute(){
        var task = new ArrayList<Task>();

        return task;
    }
}
