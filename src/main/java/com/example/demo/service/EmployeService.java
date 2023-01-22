package com.example.demo.service;


import com.example.demo.entity.Employe;
import com.example.demo.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeService {


    @Autowired
    private EmployeRepository employeRepository;

    public Employe saveEmploye(Employe employe){
        return employeRepository.save(employe);

    }
    public List<Employe> saveAllEmployees(List<Employe> employes){
        return employeRepository.saveAll(employes);

    }

    public List<Employe> getAllEmployees(){

        return employeRepository.findAll();
    }

    public Employe getEmployeById(int id){
        Employe employe = employeRepository.findById(id).orElseThrow( ()-> new RuntimeException(" Not found with that id"));
        return employe;

    }
    public String deleteById(int id){
         employeRepository.deleteById(id);
         return " removed the id "+id;

    }

    public Employe updateEmploye(int id,Employe employe){
        Employe emps = employeRepository.findById(id).orElseThrow(()-> new RuntimeException(" Not found with that id"));
        emps.setName(employe.getName());
        emps.setSalary(employe.getSalary());
        return employeRepository.save(emps);
    }
}
