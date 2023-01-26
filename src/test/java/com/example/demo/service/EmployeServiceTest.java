package com.example.demo.service;


import com.example.demo.entity.Employe;
import com.example.demo.repository.EmployeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class EmployeServiceTest {

    @Autowired
    private EmployeService employeService;

    @MockBean
    private EmployeRepository employeRepository;

    @Test
    public void getAllEmployess(){
        List<Employe> emps = Arrays.asList(new Employe(1,900.0,"hermoine"),
                new Employe(2,670.0,"Harrypotter"));
        when(employeRepository.findAll()).thenReturn(emps);
        assertEquals(2,employeService.getAllEmployees().size());
    }

    @Test
    public void saveEmploye(){
        Employe employe = new Employe(1,900.0,"hermoine");
        when(employeRepository.save(employe)).thenReturn(employe);
        assertEquals(employe,employeService.saveEmploye(employe));
    }

    @Test
    public void saveAllEmployes(){
        List<Employe> emps = Arrays.asList(new Employe(1,900.0,"hermoine"),
                new Employe(2,670.0,"Harrypotter"));
        when(employeRepository.saveAll(emps)).thenReturn(emps);
        assertEquals(emps,employeService.saveAllEmployees(emps));
    }

    @Test
    public void getEmployeById(){
        //int id =1;
        Employe employe = new Employe(1,900.0,"hermoine");
        when(employeRepository.findById(employe.getId())).thenReturn(Optional.of(employe));
        assertEquals(employe,employeService.getEmployeById(employe.getId()));


    }
    @Test
    public void deleteEmployeById(){
        Employe employe = new Employe(1,900.0,"hermoine");
        employeService.deleteById(employe.getId());
        verify(employeRepository,times(1)).deleteById(employe.getId());
    }
    @Test
    public void updateEmploye(){
        Employe employe = new Employe(1,900.0,"hermoine");
        when(employeRepository.findById(employe.getId())).thenReturn(Optional.of(employe));
       // assertEquals(employeService.updateEmploye(employe.getId(),employe),times(1));


    }
}
