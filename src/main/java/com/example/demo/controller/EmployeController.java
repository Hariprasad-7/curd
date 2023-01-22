package com.example.demo.controller;


import com.example.demo.entity.Employe;
import com.example.demo.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeController {

    @Autowired
    private EmployeService employeService;


    @PostMapping("/save")
    public Employe addEmploye(@RequestBody Employe employe){
        return employeService.saveEmploye(employe);

    }

    @PostMapping("/saves")
    public List<Employe> addEmployes(@RequestBody List<Employe> employes){
        return employeService.saveAllEmployees(employes);
    }

    @GetMapping("/get")
    public List<Employe> getAllEmployes(){
        return employeService.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public Employe getEmployeById(@PathVariable("id") int id){
        return employeService.getEmployeById(id);

    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") int id){
        return employeService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Employe updateEmployeById(@PathVariable("id") int id, @RequestBody Employe employe){

        return employeService.updateEmploye(id,employe);
    }
}
