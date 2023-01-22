package com.example.demo.controller;


import com.example.demo.entity.Task;
import com.example.demo.service.Taskservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private Taskservice taskservice;

    @PostMapping("/{id}")
    public Task saveTask(@PathVariable("id") int id, @RequestBody Task task){
        return taskservice.createTask(id,task);

    }
}
