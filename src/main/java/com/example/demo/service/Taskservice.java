package com.example.demo.service;


import com.example.demo.entity.Employe;
import com.example.demo.entity.Task;
import com.example.demo.repository.EmployeRepository;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Taskservice {


    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EmployeRepository employeRepository;

    public Task createTask(int id,Task task){
        Employe empId = (Employe) employeRepository.findById(id).orElseThrow(()-> new RuntimeException(" ID NOT FOUND"));
        task.setEmploye(empId);
        return taskRepository.save(task);

    }
}
